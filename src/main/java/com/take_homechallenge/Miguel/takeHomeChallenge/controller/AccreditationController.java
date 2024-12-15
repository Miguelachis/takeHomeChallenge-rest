package com.take_homechallenge.Miguel.takeHomeChallenge.controller;


import com.take_homechallenge.Miguel.takeHomeChallenge.domain.Accreditation;
import com.take_homechallenge.Miguel.takeHomeChallenge.domain.AccreditationApprovalresult;
import com.take_homechallenge.Miguel.takeHomeChallenge.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.take_homechallenge.Miguel.takeHomeChallenge.service.AccreditationService;


@RestController
@RequestMapping("/user")
public class AccreditationController {
    private final AccreditationService accreditationService;

    @Autowired
    public AccreditationController(AccreditationService accreditationService, DocumentService documentService) {
        this.accreditationService = accreditationService;
    }

    @PutMapping("/accreditation")
    public ResponseEntity<?> createAccreditation(@RequestBody Accreditation accreditation) {
        try {
            Optional<Accreditation> savedAccreditation = Optional.ofNullable(accreditationService.createNewAccreditationWithDocument(accreditation));
            if (savedAccreditation.isPresent()) {
                return ResponseEntity.ok(savedAccreditation);
            } else {
                return ResponseEntity.badRequest().body("Accreditation already exists with this ID");
            }
        } catch (Exception e) {
            // Catch any other unexpected exception
            return ResponseEntity.status(400).body("Unexpected error: " + e.getMessage());
        }
    }

    @PutMapping("/accreditation/{accreditationId}")
    public ResponseEntity<?> ApproveAccreditation(@PathVariable final String accreditationId) {
        try {
            Optional<AccreditationApprovalresult> AccreditationApprovalresult = Optional.ofNullable(accreditationService.ApproveAccreditation(accreditationId));
            if (AccreditationApprovalresult.isPresent()) {
                return ResponseEntity.ok(AccreditationApprovalresult);
            }
            return ResponseEntity.badRequest().body("Accreditation Could Not Be Approved");
        } catch (Exception e) {
            // Catch any other unexpected exception
            return ResponseEntity.status(400).body("Unexpected error: " + e.getMessage());
        }
    }

    @GetMapping("/{UserId}/accreditation")
    public ResponseEntity<?> GetAccreditationByUserId(@PathVariable final String UserId) {
        try {
            return ResponseEntity.ok(accreditationService.getUserAccreditationsByUserId(UserId));
        } catch (Exception e) {
            // Catch any other unexpected exception
            return ResponseEntity.status(400).body("Unexpected error: " + e.getMessage());
        }
    }
}



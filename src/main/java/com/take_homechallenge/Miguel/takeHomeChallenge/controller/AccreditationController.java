package com.take_homechallenge.Miguel.takeHomeChallenge.controller;


import com.take_homechallenge.Miguel.takeHomeChallenge.domain.Accreditation;
import com.take_homechallenge.Miguel.takeHomeChallenge.domain.AccreditationApprovalResoult;
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
    private final DocumentService documentService;
    @Autowired
    public AccreditationController(AccreditationService accreditationService,DocumentService documentService) {
        this.accreditationService = accreditationService;
        this.documentService = documentService;
    }

    @PutMapping("/accreditation")
    public ResponseEntity<?> createAccreditation(@RequestBody Accreditation accreditation) {
        Optional<Accreditation> savedAccreditation = Optional.ofNullable(accreditationService.createNewAccreditationWithDocument(accreditation));
            if (savedAccreditation.isPresent()) {
            return ResponseEntity.ok(savedAccreditation);
        } else {
            return ResponseEntity.badRequest().body("Accreditation already exists with this ID");
        }
    }

    @PutMapping("/accreditation/{accreditationId}")
    public ResponseEntity<?> createAccreditation(@PathVariable final String accreditationId) {
        Optional<AccreditationApprovalResoult> AccreditationApprovalResoult = Optional.ofNullable(accreditationService.ApproveAccreditation(accreditationId));
        if (AccreditationApprovalResoult.isPresent()) {
            return ResponseEntity.ok(AccreditationApprovalResoult);
        }
        return ResponseEntity.badRequest().body("Accreditation Could Not Be Approved");
        }
    }



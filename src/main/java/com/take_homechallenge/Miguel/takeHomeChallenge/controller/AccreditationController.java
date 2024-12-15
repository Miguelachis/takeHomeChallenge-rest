package com.take_homechallenge.Miguel.takeHomeChallenge.controller;


import com.take_homechallenge.Miguel.takeHomeChallenge.domain.Accreditation;
import com.take_homechallenge.Miguel.takeHomeChallenge.domain.AccreditationStatus;
import com.take_homechallenge.Miguel.takeHomeChallenge.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.take_homechallenge.Miguel.takeHomeChallenge.service.AccreditationService;

@RestController

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
}


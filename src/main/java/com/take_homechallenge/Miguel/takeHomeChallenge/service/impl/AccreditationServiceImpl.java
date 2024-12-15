package com.take_homechallenge.Miguel.takeHomeChallenge.service.impl;

import com.take_homechallenge.Miguel.takeHomeChallenge.domain.Accreditation;
import com.take_homechallenge.Miguel.takeHomeChallenge.domain.AccreditationEntity;
import com.take_homechallenge.Miguel.takeHomeChallenge.domain.AccreditationStatus;
import com.take_homechallenge.Miguel.takeHomeChallenge.service.AccreditationService;

import com.take_homechallenge.Miguel.takeHomeChallenge.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.take_homechallenge.Miguel.takeHomeChallenge.repositorie.AccreditationRepository;

@Service
public class AccreditationServiceImpl implements AccreditationService {

    private final AccreditationRepository accreditationRepository ;
    private final DocumentService documentService;

    @Autowired
    public AccreditationServiceImpl(final AccreditationRepository accreditationRepository ,DocumentService documentService){
        this.accreditationRepository = accreditationRepository;
        this.documentService = documentService;
    }

    @Override
    public Accreditation createNewAccreditationWithDocument(Accreditation accreditation) {
        if (!accreditationExistsById(accreditation)) {
            accreditation.setStatus(AccreditationStatus.PENDING);
            documentService.createDocument(accreditation.getDocument());
            final AccreditationEntity accreditationEntity = accreditationToAccreditationEntity(accreditation);
            final AccreditationEntity savedAccreditationEntity = accreditationRepository.save(accreditationEntity);
            return accreditationEntityToAccreditation(savedAccreditationEntity);
        }
        return null;
    }

    @Override
    public Boolean accreditationExistsById(Accreditation accreditation) {
        return accreditationRepository.existsById(accreditation.getId()) && documentService.DocumentExistsById(accreditation.getDocument().getId());
    }

    private AccreditationEntity accreditationToAccreditationEntity(Accreditation accreditation) {
        return AccreditationEntity.builder()
                .id(accreditation.getId())
                .document(documentService.documentToDocumentEntity(accreditation.getDocument()))
                .userId(accreditation.getUserId())
                .accreditation_type(accreditation.getAccreditation_type())
                .status(accreditation.getStatus())
                .build();
    }

    private Accreditation accreditationEntityToAccreditation(AccreditationEntity accreditationEntity) {
        return Accreditation.builder()
                .id(accreditationEntity.getId())
                .document(documentService.documentEntityToDocument(accreditationEntity.getDocument()))
                .userId(accreditationEntity.getUserId())
                .accreditation_type(accreditationEntity.getAccreditation_type())
                .status(accreditationEntity.getStatus())
                .build();
    }
}

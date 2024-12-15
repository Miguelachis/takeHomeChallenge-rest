package com.take_homechallenge.Miguel.takeHomeChallenge.service.impl;

import com.take_homechallenge.Miguel.takeHomeChallenge.domain.*;
import com.take_homechallenge.Miguel.takeHomeChallenge.service.AccreditationService;

import com.take_homechallenge.Miguel.takeHomeChallenge.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.take_homechallenge.Miguel.takeHomeChallenge.repositorie.AccreditationRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AccreditationServiceImpl implements AccreditationService {

    private final AccreditationRepository accreditationRepository;
    private final DocumentService documentService;

    @Autowired
    public AccreditationServiceImpl(final AccreditationRepository accreditationRepository, DocumentService documentService) {
        this.accreditationRepository = accreditationRepository;
        this.documentService = documentService;
    }

    @Override
    public Accreditation createNewAccreditationWithDocument(Accreditation accreditation) {
        if (!accreditationExistsById(accreditation.getId())) {
            if (!userHasPendingAccreditation(accreditation.getUserId())) {
                accreditation.setStatus(AccreditationStatus.PENDING);
                documentService.createDocument(accreditation.getDocument());
                final AccreditationEntity accreditationEntity = accreditationToAccreditationEntity(accreditation);
                final AccreditationEntity savedAccreditationEntity = accreditationRepository.save(accreditationEntity);
                return accreditationEntityToAccreditation(savedAccreditationEntity);
            }
        }
        return null;
    }

    @Override
    public Boolean accreditationExistsById(String accreditationId) {
        return accreditationRepository.existsById(accreditationId);
    }

    @Override
    public Boolean userHasPendingAccreditation(String userID) {
        return (!accreditationRepository.findPendingAccreditationsByUserId(userID).isEmpty());
    }


    @Override
    public AccreditationApprovalresult ApproveAccreditation(String accreditationId) {
        if (accreditationExistsById(accreditationId)) {
            Accreditation accreditation = accreditationEntityToAccreditation(accreditationRepository.getById(accreditationId));
            if ((!accreditation.getStatus().equals(AccreditationStatus.EXPIRED)) && (!accreditation.getStatus().equals(AccreditationStatus.FAILED))) {
                accreditation.setStatus(AccreditationStatus.CONFIRMED);
                accreditationRepository.save(accreditationToAccreditationEntity(accreditation));
                return AccreditationApprovalresult.builder().outcome(accreditation.getStatus()).build();
            }
        }
        return null;

    }

    @Override
    public UserAccreditation getUserAccreditationsByUserId(String userId) {
        List<UserAccreditation> result = new ArrayList<>();
        Map<String, AccreditationStatuses> acStatuses = new HashMap<>();

        List<AccreditationEntity> AccreditationEntityList = accreditationRepository.findByUserId(userId);

        for (AccreditationEntity accreditationEntity : AccreditationEntityList) {

            AccreditationStatuses accreditationStatuse = AccreditationStatuses.builder()
                    .accreditationType(accreditationEntity.getAccreditation_type())
                    .status(accreditationEntity.getStatus())
                    .build();


            acStatuses.put(accreditationEntity.getId(), accreditationStatuse);
        }
        return UserAccreditation.builder()
                .userId(userId)
                .accreditationStatuses(acStatuses)
                .build();


    }

    @Override
    public void setExpiredAllExpiredAccreditation(LocalDateTime date) {
        List<AccreditationEntity> expiredAccreditationEntityList = accreditationRepository.findAccreditationEntityOlderThan(date);
        if (expiredAccreditationEntityList != null) {
            for (AccreditationEntity accreditationEntity : expiredAccreditationEntityList) {
                accreditationEntity.setStatus(AccreditationStatus.EXPIRED);
                accreditationRepository.save(accreditationEntity);
            }
        }
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

package com.take_homechallenge.Miguel.takeHomeChallenge.service.impl;

import com.take_homechallenge.Miguel.takeHomeChallenge.domain.Accreditation;
import com.take_homechallenge.Miguel.takeHomeChallenge.domain.AccreditationEntity;
import com.take_homechallenge.Miguel.takeHomeChallenge.domain.Document;
import com.take_homechallenge.Miguel.takeHomeChallenge.domain.DocumentEntity;
import org.jetbrains.annotations.NotNull;
import com.take_homechallenge.Miguel.takeHomeChallenge.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.take_homechallenge.Miguel.takeHomeChallenge.repositorie.DocumentRepository;

@Service
public class DocumentServiceImpl implements DocumentService {

    private final DocumentRepository documentRepository;

    @Autowired
    public DocumentServiceImpl(final DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @Override
    public Document createDocument(Document accreditation) {
        final DocumentEntity accreditationEntity = documentToDocumentEntity(accreditation);
        final DocumentEntity savedAccreditationEntity = documentRepository.save(accreditationEntity);
        return documentEntityToDocument(savedAccreditationEntity);
    }

    @Override
    public Boolean DocumentExistsById(String id) {
        return documentRepository.existsById(id);
    }

    public Document documentEntityToDocument(final @NotNull DocumentEntity documentEntity) {
        return Document.builder()
                .id(documentEntity.getId())
                .content(documentEntity.getContent())
                .Name(documentEntity.getName())
                .mime_type(documentEntity.getMime_type())
                .build();
    }

    public DocumentEntity documentToDocumentEntity(final Document document) {
        return DocumentEntity.builder()
                .id(document.getId())
                .content(document.getContent())
                .Name(document.getName())
                .mime_type(document.getMime_type())
                .build();
    }


}

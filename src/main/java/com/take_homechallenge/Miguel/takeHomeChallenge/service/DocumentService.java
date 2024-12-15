package com.take_homechallenge.Miguel.takeHomeChallenge.service;

import com.take_homechallenge.Miguel.takeHomeChallenge.domain.Document;
import com.take_homechallenge.Miguel.takeHomeChallenge.domain.DocumentEntity;

public interface DocumentService {
    Document createDocument(Document accreditation);

    Document documentEntityToDocument(final DocumentEntity documentEntity);

    DocumentEntity documentToDocumentEntity(final Document document);

    Boolean DocumentExistsById(String id);

}

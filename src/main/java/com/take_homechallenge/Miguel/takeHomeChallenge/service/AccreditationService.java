package com.take_homechallenge.Miguel.takeHomeChallenge.service;

import com.take_homechallenge.Miguel.takeHomeChallenge.domain.Accreditation;

public interface AccreditationService {

    Accreditation createNewAccreditationWithDocument(Accreditation accreditation);
    Boolean accreditationExistsById(Accreditation id);
}

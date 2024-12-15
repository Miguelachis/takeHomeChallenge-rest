package com.take_homechallenge.Miguel.takeHomeChallenge.service;

import com.take_homechallenge.Miguel.takeHomeChallenge.domain.Accreditation;
import com.take_homechallenge.Miguel.takeHomeChallenge.domain.AccreditationApprovalResoult;

public interface AccreditationService {

    Accreditation createNewAccreditationWithDocument(Accreditation accreditation);
    Boolean accreditationAndDocumentExists(Accreditation id);
    Boolean accreditationExistsById(String id);
    AccreditationApprovalResoult ApproveAccreditation(String accreditationId);

}

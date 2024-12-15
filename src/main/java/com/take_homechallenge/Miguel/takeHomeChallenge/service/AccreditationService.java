package com.take_homechallenge.Miguel.takeHomeChallenge.service;

import com.take_homechallenge.Miguel.takeHomeChallenge.domain.Accreditation;
import com.take_homechallenge.Miguel.takeHomeChallenge.domain.AccreditationApprovalresult;

import com.take_homechallenge.Miguel.takeHomeChallenge.domain.UserAccreditation;


import java.time.LocalDateTime;
import java.util.List;

public interface AccreditationService {

    Accreditation createNewAccreditationWithDocument(Accreditation accreditation);


    Boolean accreditationExistsById(String id);

    Boolean userHasPendingAccreditation(String userID);

    AccreditationApprovalresult ApproveAccreditation(String accreditationId);

    UserAccreditation getUserAccreditationsByUserId(String userId);

    void setExpiredAllExpiredAccreditation(LocalDateTime date);


}

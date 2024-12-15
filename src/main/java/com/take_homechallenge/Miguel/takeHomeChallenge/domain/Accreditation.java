package com.take_homechallenge.Miguel.takeHomeChallenge.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Accreditation {
    private String id;
    private String userId;
    private Document document ;
    private AccreditationType accreditation_type;
    private AccreditationStatus status;
}

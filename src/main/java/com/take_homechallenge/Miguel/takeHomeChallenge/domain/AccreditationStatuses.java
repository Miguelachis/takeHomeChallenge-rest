package com.take_homechallenge.Miguel.takeHomeChallenge.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccreditationStatuses {
    private AccreditationType accreditationType;
    private AccreditationStatus status;
}

package com.take_homechallenge.Miguel.takeHomeChallenge.domain;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccreditationApprovalResoult {
    @Enumerated(EnumType.STRING)
    private AccreditationStatus outcome;
}

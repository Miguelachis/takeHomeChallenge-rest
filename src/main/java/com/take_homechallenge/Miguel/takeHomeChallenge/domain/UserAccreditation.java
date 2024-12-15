package com.take_homechallenge.Miguel.takeHomeChallenge.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UserAccreditation {
    private String userId;
    private Map<String, AccreditationStatuses> accreditationStatuses;
}

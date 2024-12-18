package com.take_homechallenge.Miguel.takeHomeChallenge.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Accreditation {
    @NotNull
    private String id;
    @NotNull
    private String userId;
    @NotNull
    private Document document;
    @NotNull
    private AccreditationType accreditation_type;
    @NotNull
    private AccreditationStatus status;
}

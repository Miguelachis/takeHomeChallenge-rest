package com.take_homechallenge.Miguel.takeHomeChallenge.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Document {

    private String id;
    private String Name;
    private String content;
    private String mime_type;
}

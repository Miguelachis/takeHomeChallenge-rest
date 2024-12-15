package com.take_homechallenge.Miguel.takeHomeChallenge.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Document")
public class DocumentEntity {
    @Id
    private String id;
    private String Name;
    private String content;
    private String mime_type;
}

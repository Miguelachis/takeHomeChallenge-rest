package com.take_homechallenge.Miguel.takeHomeChallenge.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Accreditation")
public class AccreditationEntity {
    @Id
    @JoinColumn(name = "id")
    private String id;
    @JoinColumn(name = "userId")
    private String userId;
    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "document_id")
    private DocumentEntity document;

    @Enumerated(EnumType.STRING) // Enum stored as string in the database
    private AccreditationType accreditation_type;
    @Enumerated(EnumType.STRING)
    private AccreditationStatus status;

    private LocalDateTime updatedDate;


    @PrePersist
    public void prePersist() {
        this.updatedDate = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedDate = LocalDateTime.now();
    }
}


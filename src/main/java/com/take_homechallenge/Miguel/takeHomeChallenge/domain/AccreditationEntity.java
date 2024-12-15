package com.take_homechallenge.Miguel.takeHomeChallenge.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

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
    @OneToOne
    @JoinColumn(name = "document_id")
    private DocumentEntity document ;

    @Enumerated(EnumType.STRING) // Enum stored as string in the database
    private AccreditationType accreditation_type;
    @Enumerated(EnumType.STRING)
    @ColumnDefault("'PENDING'")
    private AccreditationStatus status;
}


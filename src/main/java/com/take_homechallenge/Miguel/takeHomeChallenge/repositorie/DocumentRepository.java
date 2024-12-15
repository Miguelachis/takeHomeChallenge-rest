package com.take_homechallenge.Miguel.takeHomeChallenge.repositorie;

import com.take_homechallenge.Miguel.takeHomeChallenge.domain.DocumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository  extends JpaRepository<DocumentEntity,String> {
}

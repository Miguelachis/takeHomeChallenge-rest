package com.take_homechallenge.Miguel.takeHomeChallenge.repositorie;

import com.take_homechallenge.Miguel.takeHomeChallenge.domain.AccreditationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccreditationRepository  extends JpaRepository<AccreditationEntity,String> {
    List<AccreditationEntity> id(String id);
}

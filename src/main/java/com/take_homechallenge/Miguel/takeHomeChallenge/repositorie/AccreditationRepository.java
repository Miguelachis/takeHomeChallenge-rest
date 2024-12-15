package com.take_homechallenge.Miguel.takeHomeChallenge.repositorie;

import com.take_homechallenge.Miguel.takeHomeChallenge.domain.AccreditationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AccreditationRepository extends JpaRepository<AccreditationEntity, String> {
    List<AccreditationEntity> id(String id);

    List<AccreditationEntity> findByUserId(String UserId);

    @Query("SELECT e FROM AccreditationEntity e WHERE e.updatedDate < :date")
    List<AccreditationEntity> findAccreditationEntityOlderThan(@Param("date") LocalDateTime date);

    @Query("SELECT e FROM AccreditationEntity e WHERE e.status = 'PENDING' AND e.userId  = :userId")
    List<AccreditationEntity> findPendingAccreditationsByUserId(@Param("userId") String userId);

}

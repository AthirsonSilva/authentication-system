package com.authenticationsystem.repository;

import com.authenticationsystem.entity.ConfirmationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, Long> {
    @Query("SELECT t FROM ConfirmationToken t WHERE t.token = ?1")
    Optional<ConfirmationToken> findByToken(String token);
}

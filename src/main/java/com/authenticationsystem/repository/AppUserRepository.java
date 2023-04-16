package com.authenticationsystem.repository;

import com.authenticationsystem.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    @Query("SELECT u FROM AppUser u WHERE u.email LIKE ?1")
    Optional<AppUser> findByEmail(String email);

    @Transactional
    @Modifying
    @Query("UPDATE AppUser a SET a.enabled = TRUE WHERE a.email LIKE ?1")
    int enableAppUser(String email);
}

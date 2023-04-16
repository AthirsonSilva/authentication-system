package com.authenticationsystem.service;

import com.authenticationsystem.entity.ConfirmationToken;
import com.authenticationsystem.repository.ConfirmationTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ConfirmationTokenService {
    private final ConfirmationTokenRepository repository;

    public void save(ConfirmationToken token) {
        repository.save(token);
    }

    public ConfirmationToken getToken(String token) {
        return repository.findByToken(token)
                .orElseThrow(() -> new IllegalStateException("Token not found"));
    }

    public int setConfirmedAt(String token) {
        return repository.updateConfirmedAt(token, LocalDateTime.now());
    }
}

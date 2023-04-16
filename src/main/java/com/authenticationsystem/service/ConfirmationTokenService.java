package com.authenticationsystem.service;

import com.authenticationsystem.entity.ConfirmationToken;
import com.authenticationsystem.repository.ConfirmationTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConfirmationTokenService {
    private final ConfirmationTokenRepository repository;

    public void save(ConfirmationToken token) {
        repository.save(token);
    }
}

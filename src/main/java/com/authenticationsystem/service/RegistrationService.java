package com.authenticationsystem.service;

import com.authenticationsystem.app.payload.RegistrationRequest;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    public String register(RegistrationRequest request) {
        return "Success";
    }
}

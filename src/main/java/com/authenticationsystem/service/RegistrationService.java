package com.authenticationsystem.service;

import com.authenticationsystem.entity.AppUser;
import com.authenticationsystem.entity.ConfirmationToken;
import com.authenticationsystem.entity.UserRole;
import com.authenticationsystem.entity.payload.RegistrationRequest;
import com.authenticationsystem.utils.EmailValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RegistrationService {
    private final AppUserService appUserService;
    private final EmailValidator emailValidator;
    private final BCryptPasswordEncoder passwordEncoder;
    private final ConfirmationTokenService tokenService;

    public String register(RegistrationRequest request) {
        if (!emailValidator.test(request.email()))
            throw new IllegalStateException("email not valid");

        AppUser appUser = new AppUser(
                request.firstName(),
                request.lastName(),
                request.email(),
                request.password(),
                UserRole.USER
        );

        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));

        appUserService.signUpUser(appUser);

        ConfirmationToken token = new ConfirmationToken(
                UUID.randomUUID().toString(),
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                appUser
        );

        tokenService.save(token);

        return token.toString();
    }
}

package com.authenticationsystem.service;

import com.authenticationsystem.app.AppUser;
import com.authenticationsystem.app.UserRole;
import com.authenticationsystem.app.payload.RegistrationRequest;
import com.authenticationsystem.utils.EmailValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationService {
    private final AppUserService appUserService;
    private final EmailValidator emailValidator;
    private final BCryptPasswordEncoder passwordEncoder;

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

        return appUserService.signUpUser(appUser);
    }
}

package com.authenticationsystem.app.payload;

public record RegistrationRequest(
        String firstName,
        String lastname,
        String email,
        String password
) {
}

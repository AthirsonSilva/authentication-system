package com.authenticationsystem.app.payload;

public record RegistrationRequest(
        String firstName,
        String lastName,
        String email,
        String password
) {
}

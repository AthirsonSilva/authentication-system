package com.authenticationsystem.entity.payload;

public record RegistrationRequest(
        String firstName,
        String lastName,
        String email,
        String password
) {
}

package com.authenticationsystem.app;

public enum UserRole {
    ADMIN,
    USER;

    public static UserRole fromString(String value) {
        return valueOf(value.toUpperCase());
    }
}

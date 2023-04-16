package com.authenticationsystem.entity;

public enum UserRole {
    ADMIN,
    USER;

    public static UserRole fromString(String value) {
        return valueOf(value.toUpperCase());
    }
}

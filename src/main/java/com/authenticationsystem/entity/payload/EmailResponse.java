package com.authenticationsystem.entity.payload;

public record EmailResponse(
        String ownerRef,
        String fromEmail,
        String bodyEmail
) {
}

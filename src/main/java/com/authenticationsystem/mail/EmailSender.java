package com.authenticationsystem.mail;

public interface EmailSender {
    void buildAndSend(String to, String email);

    void externalSender(String ownerRef, String emailBody);

    String buildEmail(String name, String link);
}

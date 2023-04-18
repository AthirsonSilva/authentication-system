package com.authenticationsystem.mail;

public interface EmailSender {
    void send(String to, String email);
}

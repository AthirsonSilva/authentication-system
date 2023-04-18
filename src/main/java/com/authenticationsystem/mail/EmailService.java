package com.authenticationsystem.mail;

import com.authenticationsystem.entity.payload.EmailResponse;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Log4j2
public class EmailService implements EmailSender {
    private final JavaMailSender mailSender;
    private final RestTemplate restTemplate;

    @Value("${spring.mail.username}") // get the email from application.properties
    private String fromEmail;

    @Override
    @Async
    public void send(String to, String email) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");

            helper.setText(email, true);
            helper.setTo(to);
            helper.setSubject("Confirm your email registration");
            helper.setFrom("athirsonarceus@gmail.com");

            log.info("Sending email --> {}", helper.toString());

            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            log.error("Failed to send email: {0}", e);

            throw new IllegalStateException("Failed to send email");
        }
    }

    @Async
    public void sendEmail(String ownerRef, String emailBody) {
        String emailSenderApi = "http://localhost:8080/api/v1/email/html"; // The email microservice

        EmailResponse emailResponse = new EmailResponse(
                ownerRef,
                fromEmail,
                emailBody
        ); // Build the email
        restTemplate.postForObject(emailSenderApi, emailResponse, EmailResponse.class); // Send the email
    }
}

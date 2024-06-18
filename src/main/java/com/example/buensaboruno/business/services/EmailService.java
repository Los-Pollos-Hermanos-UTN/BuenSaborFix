package com.example.buensaboruno.business.services;

import com.itextpdf.io.IOException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendEmailWithAttachment(String to, String subject, String text, ByteArrayInputStream pdfStream, String pdfFileName) {
        MimeMessage message = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text);

            // Add PDF attachment
            InputStreamSource attachmentSource = new ByteArrayResource(pdfStream.readAllBytes());
            helper.addAttachment(pdfFileName, attachmentSource);

            mailSender.send(message);
        } catch (MessagingException | IOException e) {
            e.printStackTrace();
            // Handle the exception
        }
    }
}

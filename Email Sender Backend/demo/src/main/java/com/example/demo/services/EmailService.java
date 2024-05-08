package com.example.demo.services;

import jakarta.mail.MessagingException;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public interface EmailService {

    // send email to single person.
    void sendEmail(String to, String subject, String message);

    // send email to multiple persons.
    void sendEmail(String[] to, String subject, String message);

    // void sendEmail with HTML.
    void sendEmailWithHtml(String to, String subject, String htmlContent) throws MessagingException;

    // void send email with file.
    void sendEmailWithFile(String to, String subject, String message, File file) throws MessagingException;

    // void send email with inputfile.
    void sendEmailWithFile(String to, String subject, String message, InputStream inputStream) throws MessagingException, IOException;


}

package com.example.demo;

import com.example.demo.services.EmailService;
import jakarta.mail.MessagingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;

@SpringBootTest
public class EmailSenderTest {

    @Autowired
    private EmailService emailService;

    // send email to single person.
    @Test
    void emailSendTest(){
        System.out.println("Sending email..");
        emailService.sendEmail("demo@gmail.com","Email From Spring boot","Spring boot email");
    }


    // send email to multiple persons.
    @Test
    void sendEmailForAll() {
        String[] emailAddresses = {"demo@gmail.com", "adeshkanthali11@gmail.com"};
        for (String email : emailAddresses) {
            emailService.sendEmail(email, "Email From Spring Boot", "Spring Boot..");
        }
    }


    // void sendEmail with HTML.
    @Test
    void sendEmailWithHtml() throws MessagingException {
        String html = "" +
                "<h1 style ='color:red; border:1px solid red;'> Email With HTML </h1>" +
                "";
        emailService.sendEmailWithHtml("demo@gmail.com","Email From Spring Boot",html);
    }


    // void send email with file.
    @Test
    void sendEmailWithFile() throws MessagingException {
        emailService.sendEmailWithFile("demo@gmail.com",
                "Email From Spring Boot",
                "Spring Boot..",
                new File("D:\\Projects\\Email Sender\\Emailsender Backend\\demo\\src\\main\\java\\com\\example\\demo\\images\\IMG-2022543.png"));
    }


    @Test
    void sendEmailFileWithInputStream() throws IOException, MessagingException {

        File file = new File("D:\\Projects\\Email Sender\\Emailsender Backend\\demo\\src\\main\\java\\com\\example\\demo\\images\\IMG-2022543.png");
        InputStream inputStream = new FileInputStream(file);

        emailService.sendEmailWithFile("demo@gmail.com",
                 "Email From Spring Boot",
                "Spring Boot..", inputStream);
    }


}

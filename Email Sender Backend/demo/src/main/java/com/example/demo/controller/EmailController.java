package com.example.demo.controller;

import com.example.demo.entity.CustomResponse;
import com.example.demo.entity.EmailRequest;
import com.example.demo.services.EmailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<?> sendEmail(@RequestBody EmailRequest emailRequest) throws MessagingException {
        emailService.sendEmailWithHtml(emailRequest.getTo(),emailRequest.getSubject(),emailRequest.getMessage());
        return ResponseEntity.ok(
                CustomResponse.builder().message("Email Send Successfully").httpStatus(HttpStatus.OK).success(true).build()
        );
    }

    @PostMapping("/send-with-file")
    public ResponseEntity <CustomResponse> sendWithFile(@RequestPart EmailRequest emailRequest, @RequestPart MultipartFile file) throws IOException, MessagingException {
        emailService.sendEmailWithFile(emailRequest.getTo(),emailRequest.getSubject(),emailRequest.getMessage(),file.getInputStream());
        return ResponseEntity.ok(
                CustomResponse.builder().message("Email Send Successfully").httpStatus(HttpStatus.OK).success(true).build()
        );
    }

}
package com.example.demo.entity;

import lombok.*;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CustomResponse {

    private String message;

    private HttpStatus httpStatus;

    private boolean success = false;

}

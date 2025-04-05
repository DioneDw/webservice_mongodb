package com.example.webserviceMongodb.controllers.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StandardException{
    private Instant instant;
    private HttpStatus status;
    private String error;
    private String message;
    private String path;
}

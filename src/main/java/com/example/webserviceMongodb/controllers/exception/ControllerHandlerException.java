package com.example.webserviceMongodb.controllers.exception;

import com.example.webserviceMongodb.service.exception.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerHandlerException {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardException> objectNotFoundException(ObjectNotFoundException e, HttpServletRequest req){
        StandardException standardException = new StandardException(Instant.now(), HttpStatus.NOT_FOUND,
                "Object not found", e.getMessage(),req.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardException);
    }
}

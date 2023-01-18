package com.ancevt.pagecounter.rest.errorhandling;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.nio.file.NoSuchFileException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchFileException.class)
    public ResponseEntity<String> handleException(NoSuchFileException exception) {
        return ResponseEntity.badRequest().body("400 BAD REQUEST (No such directory)");
    }
}

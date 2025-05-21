package com.inventory.api.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(OwnerExceptionInUse.class)
    public ResponseEntity<String> handleOwnerExceptionInUse(OwnerExceptionInUse ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    @ExceptionHandler(ModelExceptionInUse.class)
    public ResponseEntity<String> handleOwnerExceptionInUse(ModelExceptionInUse ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    @ExceptionHandler(UsabilityExceptionInUse.class)
    public ResponseEntity<String> handleOwnerExceptionInUse(UsabilityExceptionInUse ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    @ExceptionHandler(ProfessionalExceptionInUse.class)
    public ResponseEntity<String> handleOwnerExceptionInUse(ProfessionalExceptionInUse ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }
}

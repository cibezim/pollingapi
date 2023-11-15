package com.polling.pollingapi.exceptions;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ErrorResponse {

    private String title;
    private int status;
    private String detail;
    private LocalDateTime timeStamp;
    private String developerMessage;
    private List<String> errors;

    // Constructors, getters, and setters

    public ErrorResponse(String title, int status, String detail, String developerMessage, List<String> errors) {
        this.title = title;
        this.status = status;
        this.detail = detail;
        this.timeStamp = LocalDateTime.now();
        this.developerMessage = developerMessage;
        this.errors = errors;
    }

    // Other methods

    public static ResponseEntity<Object> createValidationErrorResponse(BindingResult result) {
        List<String> errors = result.getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());

        return new ResponseEntity<>(
                new ErrorResponse("Validation Failed", HttpStatus.BAD_REQUEST.value(), "Input validation failed", "", errors),
                HttpStatus.BAD_REQUEST
        );
    }

    public static ResponseEntity<Object> createErrorResponse(HttpStatus status, String message) {
        return new ResponseEntity<>(new ErrorResponse(status.getReasonPhrase(), status.value(), message, "", null), status);
    }
}

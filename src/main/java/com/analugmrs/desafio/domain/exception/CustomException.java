package com.analugmrs.desafio.domain.exception;

import org.springframework.http.HttpStatus;

public class CustomException {
    private HttpStatus statusCode;
    private String message;

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CustomException(HttpStatus statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}

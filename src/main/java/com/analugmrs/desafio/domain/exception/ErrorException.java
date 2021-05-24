package com.analugmrs.desafio.domain.exception;

import org.springframework.http.HttpStatus;

public class ErrorException extends Exception{
    private HttpStatus statusCode;
    private String message;

    public ErrorException(HttpStatus statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
        this.message = message;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

package com.analugmrs.desafio.domain.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAnyException(ErrorException exception){
        CustomException customException = new CustomException(exception.getStatusCode(), exception.getMessage());
        return new ResponseEntity<>(customException, new HttpHeaders(), exception.getStatusCode());
    }
}

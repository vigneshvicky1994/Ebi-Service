package com.vignesh.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    //other exception handlers

    @ExceptionHandler(PersonNotFoundException.class)
    protected ResponseEntity handleEntityNotFound(
            PersonNotFoundException ex) {
        System.out.println(ex.toString());
        return new ResponseEntity("PersonNotFound", HttpStatus.valueOf("NOT_FOUND"));
    }
}
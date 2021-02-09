package io.codekaffee.hrpayroll.resources.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.codekaffee.hrpayroll.models.StandardError;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
    public StandardError handleException(Exception ex){
        return new StandardError(ex.getMessage(),HttpStatus.UNPROCESSABLE_ENTITY.value());
    }
}

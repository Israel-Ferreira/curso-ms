package io.codekaffee.hroauth.handlers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.codekaffee.hroauth.exceptions.EmailNotFoundException;


@RestControllerAdvice
public class UserNotFoundExceptionHandler {
    
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(EmailNotFoundException.class)
    public Map<String, Object> handleEmailNotFoundException(EmailNotFoundException ex){
        Map<String,Object> response = new HashMap<>();
        response.put("message", ex.getMessage());
        response.put("status code", ""+HttpStatus.NOT_FOUND.value());


        return response;
    }
}

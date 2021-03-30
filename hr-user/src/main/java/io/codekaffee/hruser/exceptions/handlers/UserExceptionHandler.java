package io.codekaffee.hruser.exceptions.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.codekaffee.hruser.exceptions.UserNotFoundException;
import io.codekaffee.hruser.models.User;

@RestControllerAdvice
public class UserExceptionHandler {
    

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public StandardError handleUserNotFoundException(UserNotFoundException exception){
        StandardError errorData = new StandardError(exception.getMessage(), HttpStatus.NOT_FOUND.value(), User.class.getSimpleName());


        return errorData;
    }
}

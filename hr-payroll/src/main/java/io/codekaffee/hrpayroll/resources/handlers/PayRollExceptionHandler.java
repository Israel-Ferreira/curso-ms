package io.codekaffee.hrpayroll.resources.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.codekaffee.hrpayroll.exceptions.WorkerNotFoundException;
import io.codekaffee.hrpayroll.models.StandardError;


@RestControllerAdvice
public class PayRollExceptionHandler {

    @ExceptionHandler(WorkerNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public StandardError handleWorkerNotFoundException(WorkerNotFoundException workerNotFoundException){
        return new StandardError(workerNotFoundException.getMessage(), HttpStatus.NOT_FOUND.value());
    }
    
}

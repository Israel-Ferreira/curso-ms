package io.codekaffee.hrpayroll.exceptions;

public class WorkerNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public WorkerNotFoundException() {
        super("Trabalhador não encontrado");
    }


    public WorkerNotFoundException(String message) {
        super(message);
    }


    public WorkerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}

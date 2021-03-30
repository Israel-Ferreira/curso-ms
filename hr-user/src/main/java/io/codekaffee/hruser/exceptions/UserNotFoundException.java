package io.codekaffee.hruser.exceptions;

public class UserNotFoundException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public UserNotFoundException() {
        super("Erro: Usuário não encontrado");
    }

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }


    
    
}

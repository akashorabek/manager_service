package kz.attractor.api.exception;

public class ClientDontExistException extends RuntimeException{
    public ClientDontExistException(String message) {
        super(message);
    }
}

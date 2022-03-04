package kz.attractor.api.exception;

public class ObjectDontExistException extends RuntimeException{
    public ObjectDontExistException(String message) {
        super(message);
    }
}

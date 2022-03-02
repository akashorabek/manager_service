package kz.attractor.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<Info> handleException(Exception exception) {
        Info info = new Info();
        info.setMessage(exception.getMessage());
        return new ResponseEntity<>(info, HttpStatus.BAD_REQUEST);
    }
}
package kz.attractor.api.exception;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ErrorController {

    @GetMapping("/error")
    public ResponseEntity<ExceptionInfo> notFound() {
        ExceptionInfo info = new ExceptionInfo();
        info.setInfo("Неправильный URL");
        return new ResponseEntity<>(info, HttpStatus.NOT_FOUND);
    }
}

package ro.fiipractic.hackathon.jobyfier.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ro.fiipractic.hackathon.jobyfier.exception.NotFoundException;

@RestControllerAdvice
public class NotFoundAdvice {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFoundHandler(NotFoundException ex) {
        return ex.getMessage();
    }
}

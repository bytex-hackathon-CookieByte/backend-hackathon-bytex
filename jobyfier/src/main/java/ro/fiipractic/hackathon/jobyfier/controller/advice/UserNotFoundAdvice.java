package ro.fiipractic.hackathon.jobyfier.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ro.info.iasi.fiipractic.twitter.exception.NotFoundException;

@RestControllerAdvice
public class UserNotFoundAdvice {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String userNotFoundHandler(NotFoundException ex) {
        return ex.getMessage();
    }
}
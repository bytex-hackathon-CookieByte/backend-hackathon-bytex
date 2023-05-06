package ro.fiipractic.hackathon.jobyfier.exception;

public class BadRequestException extends RuntimeException{

    public BadRequestException(String message) {
        super(message);
    }
}

package org.example.exception;

public class AlreadyMarkedAsDeceasedException extends RuntimeException {
    public AlreadyMarkedAsDeceasedException(String message) {
        super(message);
    }
}

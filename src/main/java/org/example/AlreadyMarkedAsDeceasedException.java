package org.example;

public class AlreadyMarkedAsDeceasedException extends RuntimeException {
    public AlreadyMarkedAsDeceasedException(String message) {
        super(message);
    }
}

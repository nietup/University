package org.example.exception;

public class EntityNotFoundException extends RuntimeException {

    private static final String MESSAGE = "Entity was not found";

    public EntityNotFoundException() {
        super(MESSAGE);
    }
}

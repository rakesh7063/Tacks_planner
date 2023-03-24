package com.task.exception;

public class SprintNotFoundException extends RuntimeException{
    public SprintNotFoundException(String message) {
        super(message);
    }

    public SprintNotFoundException() {
    }
}

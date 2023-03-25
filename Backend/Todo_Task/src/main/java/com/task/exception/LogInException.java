package com.task.exception;

public class LogInException extends RuntimeException{
    public LogInException(String message) {
        super(message);
    }

    public LogInException() {
    }
}

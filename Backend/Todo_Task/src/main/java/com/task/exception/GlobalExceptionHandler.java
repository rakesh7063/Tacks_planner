package com.task.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MyErrorDetails> myMANVExceptionHandler(MethodArgumentNotValidException me) {
        MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(),"Validation Error",me.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(SprintNotFoundException.class)
    public ResponseEntity<MyErrorDetails> SprintExceptionHandler(Exception re, WebRequest req){

        MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(),re.getMessage(),req.getDescription(false));

        return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);


    }

    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<MyErrorDetails> TaskExceptionHandler(Exception re, WebRequest req){

        MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(),re.getMessage(),req.getDescription(false));

        return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);


    }
    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<MyErrorDetails> UserExceptionHandler(Exception re, WebRequest req){

        MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(),re.getMessage(),req.getDescription(false));

        return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);


    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MyErrorDetails> anyExceptionHandler(Exception re, WebRequest req){

        MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(),re.getMessage(),req.getDescription(false));

        return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);


    }
    @ExceptionHandler(LogInException.class)
    public ResponseEntity<MyErrorDetails> LogIntExceptionHandler(Exception re, WebRequest req){

        MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(),re.getMessage(),req.getDescription(false));

        return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);


    }
}

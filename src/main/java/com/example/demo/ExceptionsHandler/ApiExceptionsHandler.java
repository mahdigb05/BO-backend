package com.example.demo.ExceptionsHandler;
import java.sql.Timestamp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.Beans.ApiException;
import com.example.demo.Exceptions.EmailOrTelAlreadyExistException;

@ControllerAdvice
public class ApiExceptionsHandler {

    @ExceptionHandler(value = {EmailOrTelAlreadyExistException.class})
    public ResponseEntity<?> emailAlreadyExistHandler(EmailOrTelAlreadyExistException e){
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        ApiException apiException = new ApiException(e.getMessage(), httpStatus, new Timestamp(System.currentTimeMillis()));
        return  new ResponseEntity<>(apiException,httpStatus);
    }
    
    @ExceptionHandler(value = {BadCredentialsException.class})
    public ResponseEntity<?> BadCredentialsExceptionHandler(BadCredentialsException e){
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        ApiException apiException = new ApiException(e.getMessage(), httpStatus, new Timestamp(System.currentTimeMillis()));
        return  new ResponseEntity<>(apiException,httpStatus);
    }

    

}

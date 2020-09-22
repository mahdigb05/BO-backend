package com.example.demo.Beans;
import java.sql.Timestamp;

import org.springframework.http.HttpStatus;

public class ApiException {

    final private String message;
    final private HttpStatus httpStatus;
    final private Timestamp timestamp;

    public ApiException(String message, HttpStatus httpStatus, Timestamp timestamp) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }
}

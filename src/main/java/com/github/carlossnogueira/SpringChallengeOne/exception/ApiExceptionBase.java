package com.github.carlossnogueira.SpringChallengeOne.exception;

import org.springframework.http.HttpStatus;

public class ApiExceptionBase extends RuntimeException {
    
    private final HttpStatus status;

    public ApiExceptionBase(String message, HttpStatus status){
        super(message);
        this.status = status;
    }

    public HttpStatus geStatus(){
        return this.status;
    }

}

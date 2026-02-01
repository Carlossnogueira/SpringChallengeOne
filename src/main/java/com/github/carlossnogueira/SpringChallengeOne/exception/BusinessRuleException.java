package com.github.carlossnogueira.SpringChallengeOne.exception;

import org.springframework.http.HttpStatus;

public class BusinessRuleException extends ApiExceptionBase {

    public BusinessRuleException(String message, HttpStatus status) {
        super(message, status);
    }

}

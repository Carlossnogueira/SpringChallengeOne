package com.github.carlossnogueira.SpringChallengeOne.exception;

import org.springframework.http.HttpStatus;

public class PersonAlreadyExistsException extends ApiExceptionBase {

    private static final String DEFAULT_MESSAGE = "Person already exists";

    public PersonAlreadyExistsException() {
        super(DEFAULT_MESSAGE, HttpStatus.CONFLICT);
    }

}

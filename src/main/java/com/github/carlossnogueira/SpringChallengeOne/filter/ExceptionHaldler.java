package com.github.carlossnogueira.SpringChallengeOne.filter;

import java.time.Instant;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.github.carlossnogueira.SpringChallengeOne.exception.ApiExceptionBase;
import com.github.carlossnogueira.SpringChallengeOne.exception.ErrorResponse;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ExceptionHaldler {

    @ExceptionHandler(value = ApiExceptionBase.class)
    public ResponseEntity<ErrorResponse> handleException(ApiExceptionBase ex, HttpServletRequest request){
        
        ErrorResponse error = ErrorResponse.builder()
        .timestamp(Instant.now())
        .status(ex.geStatus().value())
        .error(ex.geStatus())
        .message(ex.getMessage())
        .path(request.getRequestURI())
        .build();

        return ResponseEntity.status(error.getStatus()).body(error);
    }

}

package com.github.carlossnogueira.SpringChallengeOne.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ValidationErrorResponse {
    private Instant timestamp;
    private int status;
    private HttpStatus error;
    private List<String> messages;
    private String path;
}

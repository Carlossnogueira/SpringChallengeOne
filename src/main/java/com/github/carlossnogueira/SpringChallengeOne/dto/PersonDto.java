package com.github.carlossnogueira.SpringChallengeOne.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PersonDto {
  
    @Min(value = 3) @Max(value = 100)
    @NotBlank
    private String name;

    @Email
    @NotBlank
    private String email;

    private LocalDate birthDate;
}

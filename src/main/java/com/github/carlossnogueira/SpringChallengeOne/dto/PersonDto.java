package com.github.carlossnogueira.SpringChallengeOne.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter @Setter
public class PersonDto {

    @NotBlank
    @Length(max = 100, min = 3)
    private String name;

    @Email
    @NotBlank
    private String email;

    private LocalDate birthDate;
}

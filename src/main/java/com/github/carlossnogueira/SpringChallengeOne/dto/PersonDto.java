package com.github.carlossnogueira.SpringChallengeOne.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PersonDto {

    @NotBlank(message = "Name can't be blank")
    @Size(min = 3, max = 100, message = "Name need be between 3 and 100 characters")
    private String name;

    @Email(message = "Invalid email")
    @NotBlank(message = "Email can't be blank")
    private String email;

    private LocalDate birthDate;
}

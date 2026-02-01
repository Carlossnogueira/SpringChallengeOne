package com.github.carlossnogueira.SpringChallengeOne.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.carlossnogueira.SpringChallengeOne.dto.PersonDto;
import com.github.carlossnogueira.SpringChallengeOne.service.PersonService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("person")
@AllArgsConstructor
public class PersonController {
    
    private final PersonService service;

    @PostMapping()
    public ResponseEntity<String> createPerson(@RequestBody @Valid PersonDto personDto) {
        this.service.createPerson(personDto);
        return ResponseEntity.status(HttpStatus.OK.value()).body("Person created!");
    }
    


}

package com.github.carlossnogueira.SpringChallengeOne.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.carlossnogueira.SpringChallengeOne.domain.Person;
import com.github.carlossnogueira.SpringChallengeOne.dto.PageResponse;
import com.github.carlossnogueira.SpringChallengeOne.dto.PersonDto;
import com.github.carlossnogueira.SpringChallengeOne.service.PersonService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping()
    public ResponseEntity<PageResponse<Person>> listPerson(@RequestParam(defaultValue = "1") int page) {
        int pageIndex = Math.max(page - 1, 0);
        var result = service.listUsers(pageIndex);
        return ResponseEntity.ok(result);
    }

}

package com.github.carlossnogueira.SpringChallengeOne.service;

import org.springframework.stereotype.Service;

import com.github.carlossnogueira.SpringChallengeOne.dto.PersonDto;
import com.github.carlossnogueira.SpringChallengeOne.repository.PersonRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PersonService {
    
    private final PersonRepository repository;

    public void createPerson(PersonDto personDto){
        
    }

}

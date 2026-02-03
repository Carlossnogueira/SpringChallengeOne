package com.github.carlossnogueira.SpringChallengeOne.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.github.carlossnogueira.SpringChallengeOne.domain.Person;
import com.github.carlossnogueira.SpringChallengeOne.dto.PageResponse;
import com.github.carlossnogueira.SpringChallengeOne.dto.PersonDto;
import com.github.carlossnogueira.SpringChallengeOne.exception.PersonAlreadyExistsException;
import com.github.carlossnogueira.SpringChallengeOne.repository.PersonRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PersonService {

    private final PersonRepository repository;

    public void createPerson(PersonDto personDto) {

        var person = repository.existsByEmail(personDto.getEmail());

        if(person){
            throw new PersonAlreadyExistsException();
        }

        Person createPerson = Person.builder()
            .name(personDto.getName())
            .email(personDto.getEmail())
            .birthDate(personDto.getBirthDate())
            .build();

        this.repository.saveAndFlush(createPerson);
    }

    public PageResponse<Person> listUsers(int page){
        Pageable pageable = PageRequest.of(page, 10);
        Page<Person> result = repository.findAll(pageable);
        
        return new PageResponse<>(
            result.getContent(),
            result.getNumber(),
            result.getSize(),
            result.getTotalElements(),
            result.getTotalPages(),
            result.isFirst(),
            result.isLast()
        );
    }

}

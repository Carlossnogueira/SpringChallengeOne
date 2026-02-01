package com.github.carlossnogueira.SpringChallengeOne.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.carlossnogueira.SpringChallengeOne.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findByEmail(String email);
    Boolean existsByEmail(String email);
}

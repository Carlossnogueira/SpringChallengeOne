package com.github.carlossnogueira.SpringChallengeOne.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Person extends JpaRepository<Person, Long> {
    Optional<Person> findByEmail(String email);
}

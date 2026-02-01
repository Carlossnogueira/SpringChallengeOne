package com.github.carlossnogueira.SpringChallengeOne.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonRepository, Long> {
    Optional<PersonRepository> findByEmail(String email);
}

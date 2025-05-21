package com.inventory.api.domain.repository;

import com.inventory.api.domain.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface PersonRepository extends JpaRepository<Person, Long> {
    public Optional<Person> findByMail(String mail);
}

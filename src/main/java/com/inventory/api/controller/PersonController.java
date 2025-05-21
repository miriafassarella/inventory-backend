package com.inventory.api.controller;

import com.inventory.api.domain.model.Person;
import com.inventory.api.domain.model.Product;
import com.inventory.api.domain.repository.PersonRepository;
import com.inventory.api.domain.service.PersonService;
import com.inventory.api.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 4200)
@RestController
@RequestMapping("/users")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonService personService;

    @GetMapping
    public List<Person> list() {
        List<Person> persons = personRepository.findAll();
        return persons;
    }
    @GetMapping(params = {"page", "size"})
    @PreAuthorize("hasAuthority('ROLE_SEARCH_USER') and hasAuthority('SCOPE_read')")
    public Page<Person> listPersonsPage(Pageable pageable){
        Page<Person> persons =  personRepository.findAll(pageable);
        List<Person> personsPage =  persons.getContent();
        Page<Person> pageImpl = new PageImpl<>(personsPage, pageable, persons.getTotalElements());
        return pageImpl;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_REGISTER_USER')and hasAuthority('SCOPE_write')")
    public ResponseEntity<Person> userAdd(@RequestBody UserDTO userDTO){
        Person newUser = personService.userAdd(userDTO);
        return ResponseEntity.ok(newUser);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_DELETE_USER') and hasAuthority('SCOPE_write')")
    public ResponseEntity<Person> deletePerson(@PathVariable Long id){
        personService.removeUser(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

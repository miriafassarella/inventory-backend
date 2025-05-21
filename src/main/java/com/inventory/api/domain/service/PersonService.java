package com.inventory.api.domain.service;

import com.inventory.api.domain.model.Permission;
import com.inventory.api.domain.model.Person;
import com.inventory.api.domain.model.Product;
import com.inventory.api.domain.repository.PermissionRepository;
import com.inventory.api.domain.repository.PersonRepository;
import com.inventory.api.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Person userAdd(UserDTO userDTO){
        Person person = new Person();
        person.setName(userDTO.getName());
        person.setMail(userDTO.getMail());
        person.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        List<Permission> permissions = new ArrayList<>(permissionRepository.findAllById(userDTO.getPermissionsIds()));
        person.setPermission(permissions);

        return personRepository.save(person);
    }

    public void removeUser(Long id) {
        Optional<Person> person = personRepository.findById(id);
        personRepository.delete(person.get());
    }

}

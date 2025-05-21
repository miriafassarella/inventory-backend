package com.inventory.api.controller;


import com.inventory.api.domain.model.Type;
import com.inventory.api.domain.repository.TypeRepository;
import com.inventory.api.domain.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 4200)
@RestController
@RequestMapping("/types")
public class TypeController {

    @Autowired
    private TypeRepository typeRepository;

    @Autowired
    private TypeService typeService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping()
    public List<Type> list(){
        return typeRepository.findAll();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_REGISTER_TYPE') and hasAuthority('SCOPE_write')")
    public ResponseEntity<Type> addType(@RequestBody Type type){

        Type typeSave = typeService.addOwner(type);

        return ResponseEntity.status(HttpStatus.CREATED).body(typeSave);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_DELETE_TYPE') and hasAuthority('SCOPE_write')")
    public ResponseEntity<Type> deleteType(@PathVariable Long id){
        typeService.removeType(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

package com.inventory.api.controller;


import com.inventory.api.domain.model.Owner;
import com.inventory.api.domain.model.Person;
import com.inventory.api.domain.model.Product;
import com.inventory.api.domain.repository.OwnerRepository;
import com.inventory.api.domain.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 4200)
@RestController
@RequestMapping("/owners")
public class OwnerController {

    @Autowired
    private OwnerRepository repository;

    @Autowired
    private OwnerService ownerService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping()
    public List<Owner> list(){
        return repository.findAll();
    }

    @GetMapping(params = {"page", "size"})
    @PreAuthorize("hasAuthority('ROLE_SEARCH_OWNER') and hasAuthority('SCOPE_read')")
    public Page<Owner> listOwnerPage(Pageable pageable){
        Page<Owner> owners =  repository.findAll(pageable);
        List<Owner> ownersPage =  owners.getContent();
        Page<Owner> pageImpl = new PageImpl<>(ownersPage, pageable, owners.getTotalElements());
        return pageImpl;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_REGISTER_OWNER') and hasAuthority('SCOPE_write')")
    public ResponseEntity<Owner> addOwner(@RequestBody Owner owner){

        Owner ownerSave = ownerService.addOwner(owner);

        return ResponseEntity.status(HttpStatus.CREATED).body(ownerSave);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_DELETE_OWNER') and hasAuthority('SCOPE_write')")
    public ResponseEntity<Owner> deleteOwner(@PathVariable Long id){
        ownerService.removeOwner(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

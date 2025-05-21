package com.inventory.api.controller;

import com.inventory.api.domain.model.Owner;
import com.inventory.api.domain.model.Person;
import com.inventory.api.domain.model.Professional;
import com.inventory.api.domain.repository.ProductRepository;
import com.inventory.api.domain.repository.ProfessionalRepository;
import com.inventory.api.domain.service.ProfessionalService;
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
@RequestMapping("/professionals")
public class ProfessionalController {

    @Autowired
   private ProfessionalRepository repository;
    @Autowired
   private ProfessionalService professionalService;


    @GetMapping
    public List<Professional> list(){
        return repository.findAll();
    }

    @GetMapping(params = {"page", "size"})
    @PreAuthorize("hasAuthority('ROLE_SEARCH_PROFESSIONAL') and hasAuthority('SCOPE_read')")
    public Page<Professional> listProfessionalPage(Pageable pageable){
        Page<Professional> professionals =  repository.findAll(pageable);
        List<Professional> professionalsPage =  professionals.getContent();
        Page<Professional> pageImpl = new PageImpl<>(professionalsPage, pageable, professionals.getTotalElements());
        return pageImpl;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_REGISTER_PROFESSIONAL') and hasAuthority('SCOPE_write')")
    public ResponseEntity<Professional> addProfessional(@RequestBody Professional professional){

        Professional professionalSave = professionalService.addProfessional(professional);

        return ResponseEntity.status(HttpStatus.CREATED).body(professionalSave);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_DELETE_PROFESSIONAL') and hasAuthority('SCOPE_write')")
    public ResponseEntity<Professional> deleteProfessional(@PathVariable Long id){
        professionalService.removeProfessional(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

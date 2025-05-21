package com.inventory.api.controller;

import com.inventory.api.domain.model.Model;
import com.inventory.api.domain.model.Owner;
import com.inventory.api.domain.model.Usability;
import com.inventory.api.domain.repository.UsabilityRepository;
import com.inventory.api.domain.service.UsabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.List;

@CrossOrigin(origins = "http://3.95.208.110")
@RestController
@RequestMapping("/usabilities")
public class UsabilityController {

    @Autowired
    private UsabilityRepository repository;

    @Autowired
    private UsabilityService usabilityService;

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public List<Usability> list(){
        return repository.findAll();
    }

    @GetMapping(params = {"page", "size"})
    @PreAuthorize("hasAuthority('ROLE_SEARCH_USABILITY') and hasAuthority('SCOPE_read')")
    public Page<Usability> listUsabilityPage(Pageable pageable){
        Page<Usability> usabilities =  repository.findAll(pageable);
        List<Usability> usabilitiesPage =  usabilities.getContent();
        Page<Usability> pageImpl = new PageImpl<>(usabilitiesPage, pageable, usabilities.getTotalElements());
        return pageImpl;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_REGISTER_USABILITY') and hasAuthority('SCOPE_write')")
    public ResponseEntity<Usability> addUsability(@RequestBody Usability usability){

        Usability usabilitySave = usabilityService.addUsability(usability);

        return ResponseEntity.status(HttpStatus.CREATED).body(usabilitySave);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_DELETE_USABILITY') and hasAuthority('SCOPE_write')")
    public ResponseEntity<Usability> deleteUsability(@PathVariable Long id){
        usabilityService.removeUsability(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}

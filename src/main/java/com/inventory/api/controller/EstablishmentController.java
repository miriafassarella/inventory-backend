package com.inventory.api.controller;

import com.inventory.api.domain.model.Establishment;
import com.inventory.api.domain.model.Sector;
import com.inventory.api.domain.repository.EstablishementRepository;

import com.inventory.api.domain.repository.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 4200)
@RestController
@RequestMapping("/establishments")
public class EstablishmentController {

    @Autowired
    EstablishementRepository repository;


    
    @PreAuthorize("isAuthenticated()")
    @GetMapping(params = "sector")
    public List<Establishment> listBySectors(@RequestParam Long sector){
       return repository.findBySectorId(sector);
    }

    @GetMapping()
    @PreAuthorize("isAuthenticated()")
    public List<Establishment> list(){
        return repository.findAll();
    }


}

package com.inventory.api.controller;

import com.inventory.api.domain.model.Sector;
import com.inventory.api.domain.repository.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 4200)
@RestController
@RequestMapping("/sectors")
public class SectorController {

    @Autowired
    SectorRepository sectorRepository;

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public List<Sector> list(){
        return sectorRepository.findAll();
    }

}

package com.inventory.api.controller;

import com.inventory.api.domain.model.Permission;
import com.inventory.api.domain.model.Product;
import com.inventory.api.domain.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 4200)
@RestController
@RequestMapping("permissions")
public class PermissionController {

    @Autowired
    private PermissionRepository permissionRepository;

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_SEARCH_PERMISSION') and hasAuthority('SCOPE_read')")
    public List<Permission> list(){
        List<Permission> permission = permissionRepository.findAll();
        return permission;
    }
}

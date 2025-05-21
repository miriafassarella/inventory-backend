package com.inventory.api.controller;

import com.inventory.api.domain.model.Model;
import com.inventory.api.domain.model.Owner;
import com.inventory.api.domain.repository.ModelRepositoy;
import com.inventory.api.domain.service.ModelService;
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
@RequestMapping("/models")
public class ModelController {

    @Autowired
    private ModelService modelService;

    @Autowired
    private ModelRepositoy modelRepositoy;

    @GetMapping
    public List<Model> list(){
        return modelRepositoy.findAll();
    }

    @GetMapping(params = {"page", "size"})
    @PreAuthorize("hasAuthority('ROLE_SEARCH_MODEL') and hasAuthority('SCOPE_read')")
    public Page<Model> listModelPage(Pageable pageable){
        Page<Model> models =  modelRepositoy.findAll(pageable);
        List<Model> modelsPage =  models.getContent();
        Page<Model> pageImpl = new PageImpl<>(modelsPage, pageable, models.getTotalElements());
        return pageImpl;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_REGISTER_MODEL') and hasAuthority('SCOPE_write')")
    public ResponseEntity<Model> addModel(@RequestBody Model model){

        Model modelSave = modelService.addModel(model);

        return ResponseEntity.status(HttpStatus.CREATED).body(modelSave);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_DELETE_MODEL') and hasAuthority('SCOPE_write')")
    public ResponseEntity<Model> deleteModel(@PathVariable Long id){
        modelService.removeModel(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

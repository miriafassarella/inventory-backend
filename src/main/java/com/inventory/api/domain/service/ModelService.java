package com.inventory.api.domain.service;

import com.inventory.api.domain.model.Model;
import com.inventory.api.domain.model.Owner;
import com.inventory.api.domain.repository.ModelRepositoy;
import com.inventory.api.domain.repository.ProductRepository;
import com.inventory.api.handler.OwnerExceptionInUse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ModelService {

    @Autowired
    private ModelRepositoy modelRepositoy;

    @Autowired
    private ProductRepository productRepository;

    public Model addModel(Model model) {
        return modelRepositoy.save(model);
    }

    public void removeModel(Long id) {
        Optional<Model> model = modelRepositoy.findById(id);
        if (productRepository.existsByModel(model.get())) {
            throw new OwnerExceptionInUse("Il n'est pas possible de supprimer le modèle car il est lié à un ou plusieurs produits.");
        }
        modelRepositoy.delete(model.get());

    }
}

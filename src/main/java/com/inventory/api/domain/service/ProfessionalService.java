package com.inventory.api.domain.service;



import com.inventory.api.domain.model.Owner;
import com.inventory.api.domain.model.Professional;

import com.inventory.api.domain.repository.ProductRepository;
import com.inventory.api.domain.repository.ProfessionalRepository;
import com.inventory.api.handler.OwnerExceptionInUse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfessionalService {

    @Autowired
    private ProfessionalRepository professionalRepository;

    @Autowired
    private ProductRepository productRepository;

    public Professional addProfessional(Professional professional) {
        return professionalRepository.save(professional);
    }

    public void removeProfessional(Long id) {
        Optional<Professional> professional = professionalRepository.findById(id);
        if (productRepository.existsByProfessional(professional.get())) {
            throw new OwnerExceptionInUse("Il n'est pas possible de supprimer l'enseignant car il est lié à un ou plusieurs produits.");
        }
        professionalRepository.delete(professional.get());


    }
}

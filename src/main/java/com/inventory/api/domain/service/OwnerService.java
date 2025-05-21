package com.inventory.api.domain.service;

import com.inventory.api.domain.model.Owner;
import com.inventory.api.domain.model.Person;
import com.inventory.api.domain.model.Product;
import com.inventory.api.domain.repository.OwnerRepository;
import com.inventory.api.domain.repository.ProductRepository;
import com.inventory.api.handler.OwnerExceptionInUse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private ProductRepository productRepository;

    public Owner addOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    public void removeOwner(Long id) {
        Optional<Owner> owner = ownerRepository.findById(id);
        if (productRepository.existsByOwner(owner.get())) {
            throw new OwnerExceptionInUse("Il n'est pas possible de supprimer un propriétaire car il est lié à un ou plusieurs produits.");
        }
            ownerRepository.delete(owner.get());


    }
}

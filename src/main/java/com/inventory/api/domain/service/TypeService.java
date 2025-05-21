package com.inventory.api.domain.service;

import com.inventory.api.domain.model.Owner;
import com.inventory.api.domain.model.Type;
import com.inventory.api.domain.repository.ModelRepositoy;
import com.inventory.api.domain.repository.ProductRepository;
import com.inventory.api.domain.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TypeService {

    @Autowired
    private TypeRepository typeRepository;

    @Autowired
    private ModelRepositoy modelRepositoy;

    public Type addOwner(Type type) {
        return typeRepository.save(type);
    }

    public void removeType(Long id) {
        Optional<Type> type = typeRepository.findById(id);
        if (modelRepositoy.existsByType(type.get())) {
            throw new RuntimeException("Não é possível excluir. Existem produtos associados a este tipo.");
        }else{
            typeRepository.delete(type.get());
        }

    }
}

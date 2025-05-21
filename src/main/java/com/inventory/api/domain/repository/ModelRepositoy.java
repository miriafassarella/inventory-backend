package com.inventory.api.domain.repository;


import com.inventory.api.domain.model.Model;
import com.inventory.api.domain.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepositoy extends JpaRepository<Model, Long> {
    boolean existsByType(Type type);
}

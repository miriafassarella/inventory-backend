package com.inventory.api.domain.repository;

import com.inventory.api.domain.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type, Long> {
}

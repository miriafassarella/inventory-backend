package com.inventory.api.domain.repository;

import com.inventory.api.domain.model.Professional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessionalRepository extends JpaRepository<Professional, Long> {
}

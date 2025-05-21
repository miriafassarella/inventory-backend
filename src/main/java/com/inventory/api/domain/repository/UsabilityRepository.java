package com.inventory.api.domain.repository;

import com.inventory.api.domain.model.Usability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsabilityRepository extends JpaRepository<Usability, Long> {
}

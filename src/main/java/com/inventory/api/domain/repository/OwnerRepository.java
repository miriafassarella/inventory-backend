package com.inventory.api.domain.repository;

import com.inventory.api.domain.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
}

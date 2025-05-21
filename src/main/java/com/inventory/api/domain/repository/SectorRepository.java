package com.inventory.api.domain.repository;

import com.inventory.api.domain.model.Sector;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectorRepository extends JpaRepository<Sector, Long> {
}

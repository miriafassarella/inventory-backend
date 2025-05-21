package com.inventory.api.domain.repository;

import com.inventory.api.domain.model.*;


import com.inventory.api.domain.repository.product.ProductRepositoryCustom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>, ProductRepositoryCustom {
    Page<Product> findByEstablishmentId(Long establishmentId, Pageable pageable);
    List<Product> findByEstablishmentId(Long establishmentId);

    List<Product> findByModelContaining(Model model);

    boolean existsByOwner(Owner owner);
    boolean existsByProfessional(Professional professional);
    boolean existsByUsability(Usability usability);
    boolean existsByModel(Model model);


}

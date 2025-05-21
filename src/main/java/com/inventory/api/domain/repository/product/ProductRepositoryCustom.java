package com.inventory.api.domain.repository.product;

import com.inventory.api.domain.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductRepositoryCustom {

    public Page<Product> searchProducts(ProductFilter filter, Pageable pageable);
}

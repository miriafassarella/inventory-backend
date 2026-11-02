package com.inventory.api.domain.service;

import com.inventory.api.domain.model.Establishment;
import com.inventory.api.domain.model.Product;
import com.inventory.api.domain.repository.EstablishementRepository;
import com.inventory.api.domain.repository.ProductRepository;
import com.inventory.api.domain.repository.product.ProductFilter;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    private PdfService pdfService;

    private EstablishementRepository establishementRepository;


    public ProductService(ProductRepository productRepository, PdfService pdfService,
                          EstablishementRepository establishementRepository) {
        this.productRepository = productRepository;
        this.pdfService = pdfService;
        this.establishementRepository = establishementRepository;
    }

    public byte[] exportProductsToPdf(Long establishmentId) {

        byte[] pdf;
        List<Product> products;
        Establishment establishment = null;

        if (establishmentId != null /*|| establishmentId != 0*/) {

            establishment = establishementRepository
                    .findById(establishmentId)
                    .orElseThrow(() ->
                            new RuntimeException(
                                    "Établissement introuvable"
                            )
                    );
            products = productRepository.findByEstablishmentId(establishmentId);
        } else {
            products = productRepository.findAll();
        }

        return pdfService.generateProductPdf(products, establishment.getName());
    }


    public Product listProduct(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.get();
    }

    public Page<Product> searchProducts(ProductFilter filter, Pageable pageable) {
        return productRepository.searchProducts(filter, pageable);
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> add(List<Product> product) {
        if (product.size() >= 1) {
            for (int i = 0; i < product.size(); i++) {
                productRepository.save(product.get(i));
            }
        }

        return product;
    }

    public void removeProduct(Long id) {
        Optional<Product> product = productRepository.findById(id);
        productRepository.delete(product.get());
    }

    public Product updateProduct(Long id, Product product) {
        Optional<Product> productCurrent = productRepository.findById(id);
        BeanUtils.copyProperties(product, productCurrent.get(), "id");
        return productRepository.save(productCurrent.get());
    }

}

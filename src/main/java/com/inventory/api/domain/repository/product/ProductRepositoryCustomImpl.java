package com.inventory.api.domain.repository.product;

import com.inventory.api.domain.model.Establishment;
import com.inventory.api.domain.model.Model;
import com.inventory.api.domain.model.Product;
import com.inventory.api.domain.model.Professional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoryCustomImpl implements ProductRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Page<Product> searchProducts(ProductFilter filter, Pageable pageable) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> query = builder.createQuery(Product.class);
        Root<Product> root = query.from(Product.class);


        Join<Product, Professional> professionalJoin = root.join("professional", JoinType.LEFT);
        Join<Product, Model> modelJoin = root.join("model", JoinType.LEFT);
        Join<Product, Establishment>  establishmentJoin = root.join("establishment", JoinType.LEFT);


        List<Predicate> predicates = new ArrayList<>();


        // Filtro pelo nome do produto
        if (filter.getName() != null && !filter.getName().isEmpty()) {
            predicates.add(builder.like(builder.lower(root.get("name")), "%" + filter.getName().toLowerCase() + "%"));
        }

        // Filtro pelo número de série
        if (filter.getSerialNumber() != null && !filter.getSerialNumber().isEmpty()) {
            predicates.add(builder.like(root.get("serialNumber"), "%" + filter.getSerialNumber().toLowerCase() + "%"));
        }

        // Filtro pelo nome do modelo (Relacionamento ManyToOne)
        if (filter.getModelName() != null && !filter.getModelName().isEmpty()) {
            predicates.add(builder.like(builder.lower(modelJoin.get("name")), "%" + filter.getModelName().toLowerCase() + "%"));
        }

        // Filtro pelo nome do profissional (Relacionamento ManyToOne)
        if (filter.getProfessionalName() != null && !filter.getProfessionalName().isEmpty()) {
            predicates.add(builder.like(builder.lower(professionalJoin.get("name")), "%" + filter.getProfessionalName().toLowerCase() + "%"));
        }
        if (filter.getEstablishmentId() != null) {
            predicates.add(builder.equal(establishmentJoin.get("id"), filter.getEstablishmentId()));
        }


        query.select(root).where(builder.and(predicates.toArray(new Predicate[0])));


        // Criando a query paginada
        TypedQuery<Product> typedQuery = entityManager.createQuery(query);
        typedQuery.setFirstResult((int) pageable.getOffset());
        typedQuery.setMaxResults(pageable.getPageSize());


        // Criando a consulta de contagem total
        CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
        Root<Product> countRoot = countQuery.from(Product.class);

        Join<Product, Professional> countProfessionalJoin = countRoot.join("professional", JoinType.LEFT);
        Join<Product, Model> countModelJoin = countRoot.join("model", JoinType.LEFT);
        Join<Product, Model> countEstablishmentJoin = countRoot.join("establishment", JoinType.LEFT);

        countQuery.select(builder.count(countRoot));
        countQuery.where(predicates.toArray(new Predicate[0]));
        Long totalCount = entityManager.createQuery(countQuery).getSingleResult();

        return new PageImpl<>(typedQuery.getResultList(), pageable, totalCount);
    }
}

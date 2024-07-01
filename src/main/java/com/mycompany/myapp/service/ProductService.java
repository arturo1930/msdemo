package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.Product;
import io.quarkus.panache.common.Page;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.mycompany.myapp.domain.Product}.
 */
public interface ProductService {
    /**
     * Save a product.
     *
     * @param product the entity to save.
     * @return the persisted entity.
     */
    Product persistOrUpdate(Product product);

    /**
     * Delete the "id" product.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);

    /**
     * Get all the products.
     * @param page the pagination information.
     * @return the list of entities.
     */
    public Paged<Product> findAll(Page page);

    /**
     * Get the "id" product.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Product> findOne(Long id);
}

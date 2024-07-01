package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.domain.Product;
import com.mycompany.myapp.service.Paged;
import com.mycompany.myapp.service.ProductService;
import io.quarkus.panache.common.Page;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
@Transactional
public class ProductServiceImpl implements ProductService {

    private final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Override
    @Transactional
    public Product persistOrUpdate(Product product) {
        log.debug("Request to save Product : {}", product);
        return Product.persistOrUpdate(product);
    }

    /**
     * Delete the Product by id.
     *
     * @param id the id of the entity.
     */
    @Override
    @Transactional
    public void delete(Long id) {
        log.debug("Request to delete Product : {}", id);
        Product.findByIdOptional(id).ifPresent(product -> {
            product.delete();
        });
    }

    /**
     * Get one product by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    public Optional<Product> findOne(Long id) {
        log.debug("Request to get Product : {}", id);
        return Product.findByIdOptional(id);
    }

    /**
     * Get all the products.
     * @param page the pagination information.
     * @return the list of entities.
     */
    @Override
    public Paged<Product> findAll(Page page) {
        log.debug("Request to get all Products");
        return new Paged<>(Product.findAll().page(page));
    }
}

package com.hieudev.ss5.repository;

import com.hieudev.ss5.entity.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> query = entityManager.createQuery("from Product", Product.class);
        return query.getResultList();
    }

    @Override
    public void save(Product product) {
        entityManager.persist(product);
    }

    @Override
    public Product findById(int id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public void update(int id, Product product) {

        validate(product);

        Product p = findById(id);
        if (p != null) {
            p.setName(product.getName());
            p.setPrice(product.getPrice());
            p.setDescription(product.getDescription());
            p.setManufacturer(product.getManufacturer());
            entityManager.merge(p);
        }
    }

    @Override
    public void remove(int id) {

        Product p = findById(id);
        if (p != null) {
            entityManager.remove(p);
        }
    }

    @Override
    public List<Product> searchByName(String name) {
        TypedQuery<Product> query = entityManager.createQuery(
                "select p from Product p where lower(p.name) like :name",
                Product.class
        );
        query.setParameter("name", "%" + name.toLowerCase() + "%");
        return query.getResultList();
    }

    private void validate(Product product) {
        if (product.getName() == null || product.getName().trim().isEmpty()) {
            throw new RuntimeException("Name không được để trống!");
        }
        if (product.getPrice() <= 0) {
            throw new RuntimeException("Price phải > 0!");
        }
    }
}

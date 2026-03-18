package com.hieudev.ss3.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.hieudev.ss3.entity.Product;
import com.hieudev.ss3.util.ConnectionUtil;

import jakarta.persistence.TypedQuery;

@Repository
public class ProductRepository implements IProductRepository {

    @Override
    public List<Product> findAll() {
        Session session = ConnectionUtil.sessionFactory.openSession();
        TypedQuery<Product> query = session.createNativeQuery("select * from product", Product.class);
        List<Product> productList = query.getResultList();
        session.close();
        return productList;
    }

    @Override
    public void save(Product product) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            validate(product);
            session.save(product);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public Product findById(int id) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        Product product = session.find(Product.class, id);
        session.close();
        return product;
    }

    @Override
    public void update(int id, Product product) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            validate(product);

            Product p = session.get(Product.class, id);
            if (p != null) {
                p.setName(product.getName());
                p.setPrice(product.getPrice());
                p.setDescription(product.getDescription());
                p.setManufacturer(product.getManufacturer());
                session.merge(p);
            }

            transaction.commit();

        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void remove(int id) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            Product p = session.get(Product.class, id);
            if (p != null) {
                session.delete(p);
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public List<Product> searchByName(String name) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        TypedQuery<Product> query = session.createNativeQuery(
                "select * from product where lower(name) like :name",
                Product.class
        );
        query.setParameter("name", "%" + name.toLowerCase() + "%");
        List<Product> productList = query.getResultList();
        session.close();
        return productList;
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

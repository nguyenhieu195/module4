package com.hieudev.ss5.service;

import com.hieudev.ss5.entity.Product;
import com.hieudev.ss5.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository products;

    @Override
    public List<Product> findAll() {
        return products.findAll();
    }
    @Transactional
    @Override
    public void save(Product product) {
        products.save(product);
    }

    @Override
    public Product findById(int id) {
        return products.findById(id);
    }
    @Transactional
    @Override
    public void update(int id, Product product) {
         products.update(id, product);
    }
    @Transactional
    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> searchByName(String name) {
        return products.searchByName(name);
    }
}
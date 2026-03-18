package com.hieudev.ss3.service;

import com.hieudev.ss3.entity.Product;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ProductService implements IProductService {

    private static List<Product> products = new ArrayList<>();
    private static int nextId = 1;

    static {
        products.add(new Product(nextId++, "Iphone 13", 1000, "Apple phone", "Apple"));
        products.add(new Product(nextId++, "Samsung S22", 900, "Android phone", "Samsung"));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        validate(product);
        product.setId(nextId++);
        products.add(product);
    }

    @Override
    public Product findById(int id) {
        return products.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void update(int id, Product product) {
        validate(product);

        Product existing = findById(id);
        if (existing != null) {
            existing.setName(product.getName());
            existing.setPrice(product.getPrice());
            existing.setDescription(product.getDescription());
            existing.setManufacturer(product.getManufacturer());
        }
    }

    @Override
    public void remove(int id) {
        products.removeIf(p -> p.getId() == id);
    }

    @Override
    public List<Product> searchByName(String name) {
        return products.stream()
                .filter(p -> p.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();
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
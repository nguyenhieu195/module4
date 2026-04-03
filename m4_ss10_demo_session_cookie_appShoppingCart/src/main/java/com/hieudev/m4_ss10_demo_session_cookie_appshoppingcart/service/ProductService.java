package com.hieudev.m4_ss10_demo_session_cookie_appshoppingcart.service;

import com.hieudev.m4_ss10_demo_session_cookie_appshoppingcart.model.Product;
import com.hieudev.m4_ss10_demo_session_cookie_appshoppingcart.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository productRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }
}
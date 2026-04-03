package com.hieudev.m4_ss10_demo_session_cookie_appshoppingcart.service;

import com.hieudev.m4_ss10_demo_session_cookie_appshoppingcart.model.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();

    Optional<Product> findById(Long id);
}
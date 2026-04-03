package com.hieudev.m4_ss10_demo_session_cookie_appshoppingcart.repository;

import com.hieudev.m4_ss10_demo_session_cookie_appshoppingcart.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
}

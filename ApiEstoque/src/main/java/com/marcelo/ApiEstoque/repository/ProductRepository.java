package com.marcelo.ApiEstoque.repository;

import com.marcelo.ApiEstoque.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

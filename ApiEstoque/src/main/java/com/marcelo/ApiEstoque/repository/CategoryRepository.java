package com.marcelo.ApiEstoque.repository;


import com.marcelo.ApiEstoque.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}

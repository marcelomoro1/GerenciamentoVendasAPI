package com.marcelo.ApiEstoque.repository;

import com.marcelo.ApiEstoque.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale,Long> {
}

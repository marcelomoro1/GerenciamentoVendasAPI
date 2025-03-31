package com.marcelo.ApiEstoque.repository;

import com.marcelo.ApiEstoque.model.SalesHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesHistoryRepository extends JpaRepository<SalesHistory, Long> {
}

package com.marcelo.ApiEstoque.repository;

import com.marcelo.ApiEstoque.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    boolean existsByEmail(String email);

    boolean existsByPhone(String phone);

    boolean existsByEmailAndIdNot(String email, Long id);
}

package com.marcelo.ApiEstoque.repository;

import com.marcelo.ApiEstoque.model.ItemSale;
import com.marcelo.ApiEstoque.model.ItemSaleID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemSaleRepository extends JpaRepository<ItemSale, ItemSaleID> {
}

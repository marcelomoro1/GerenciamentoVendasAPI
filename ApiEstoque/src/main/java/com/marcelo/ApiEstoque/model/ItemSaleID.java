package com.marcelo.ApiEstoque.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;
@Embeddable
@Data
public class ItemSaleID implements Serializable {
    @Column(name = "sale_id")
    private Long saleId;
    @Column(name = "product_id")
    private Long productId;

}

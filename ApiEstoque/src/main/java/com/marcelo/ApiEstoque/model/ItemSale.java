package com.marcelo.ApiEstoque.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ItemSale")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class ItemSale {

    @EmbeddedId
    private ItemSaleID id;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Float unit_price;

    //relacao com produto
    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    //relacao com venda
    @ManyToOne
    @MapsId("saleId")
    @JoinColumn(name = "sale_id", referencedColumnName = "id")
    private Sale sale;
}
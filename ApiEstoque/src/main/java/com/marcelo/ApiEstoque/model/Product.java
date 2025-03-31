package com.marcelo.ApiEstoque.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "product")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private Float price;

    @Column(nullable = false)
    private Integer quantity;

    //relacao category
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    //relacao ItemSale
    @OneToMany(mappedBy = "product")
    private List<ItemSale> items;


}
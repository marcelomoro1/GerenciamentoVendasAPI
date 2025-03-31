package com.marcelo.ApiEstoque.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Sale")
@Data
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date data;

    @Column(nullable = false)
    private Float total;

    @Column(nullable = false)
    private String payment;

    //relacao customer
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    //relacao user
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    //relacao SalesHistory
    @OneToMany(mappedBy = "sale")
    private List<ItemSale> saleHistory;
}
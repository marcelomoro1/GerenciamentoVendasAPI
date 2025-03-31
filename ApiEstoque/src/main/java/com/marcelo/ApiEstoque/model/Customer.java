package com.marcelo.ApiEstoque.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String phone;

    //relacao venda
    @OneToMany(mappedBy = "customer")
    private List<Sale> sales;


    public Customer(Long id, String name, String email, String phone, List<Sale> sales) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.sales = sales;
    }

    public Customer(String name, String email, String phone, List<Sale> sales) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.sales = sales;
    }

    public Customer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", sales=" + sales +
                '}';
    }
}
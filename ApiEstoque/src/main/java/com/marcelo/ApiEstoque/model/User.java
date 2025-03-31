package com.marcelo.ApiEstoque.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String userType;

    //relacao sale
    @OneToMany(mappedBy = "user" )
    private List<Sale> sales;

    //relacao salesHistory
    @OneToMany(mappedBy = "user" )
    private List<SalesHistory> salesHistory;


    public User() {
    }

    public User(String name, String email, String password, String userType, List<Sale> sales, List<SalesHistory> salesHistory) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.userType = userType;
        this.sales = sales;
        this.salesHistory = salesHistory;
    }

    public User(Long id, String name, String email, String password, String userType, List<Sale> sales, List<SalesHistory> salesHistory) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.userType = userType;
        this.sales = sales;
        this.salesHistory = salesHistory;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }

    public List<SalesHistory> getSalesHistory() {
        return salesHistory;
    }

    public void setSalesHistory(List<SalesHistory> salesHistory) {
        this.salesHistory = salesHistory;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userType='" + userType + '\'' +
                ", sales=" + sales +
                ", salesHistory=" + salesHistory +
                '}';
    }
}
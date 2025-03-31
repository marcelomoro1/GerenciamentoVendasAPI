package com.marcelo.ApiEstoque.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Table(name = "SalesHistory")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class SalesHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String tipoOperacao;

    @Column(nullable = false)
    private Integer quantidade;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dataHora;

    @Column(columnDefinition = "TEXT")
    private String observacao;

    //relacao user
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    //relacao sale
    @ManyToOne
    @JoinColumn(name = "sale_id", nullable = false)
    private Sale sale;

}
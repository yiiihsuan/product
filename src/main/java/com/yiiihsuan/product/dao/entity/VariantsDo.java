package com.yiiihsuan.product.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "variants")
public class VariantsDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    @JsonIgnore
    private ProductsDo product;

    @ManyToOne
    @JoinColumn(name = "color_id", nullable = false)
    private ColorsDo color;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Size size;

    @Column(nullable = false)
    private int stock;

    public enum Size {
        XS, S, M, L, XL
    }
}


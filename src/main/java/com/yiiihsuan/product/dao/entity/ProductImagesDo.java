package com.yiiihsuan.product.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
        import lombok.Data;

@Data
@Entity
@Table(name = "product_images")
public class ProductImagesDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    @JsonIgnore
    private ProductsDo product;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String imageUrl;
}


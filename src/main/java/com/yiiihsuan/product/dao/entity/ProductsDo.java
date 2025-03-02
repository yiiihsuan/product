package com.yiiihsuan.product.dao.entity;

import com.yiiihsuan.product.enums.CategoryEnum;
import com.yiiihsuan.product.enums.SaleTypeEnum;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


@Data
@Entity
@Table(name = "products")
@EqualsAndHashCode(onlyExplicitlyIncluded = true) // 只包含指定欄位
public class ProductsDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include // 只包含 `id` 來計算 hashCode
    private Long id;

    @Column(name = "product_code", nullable = false, unique = true)
    private String productCode; // 商家 SKU，確保唯一

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING) // 讓 category 存為 ENUM 字符串
    @Column(nullable = false)
    private CategoryEnum category;

    @Column
    private String texture;

    @Column
    private String wash;

    @Column(columnDefinition = "TEXT")
    private String place;

    @Column(columnDefinition = "TEXT")
    private String note;

    @Column(columnDefinition = "TEXT")
    private String story;

    @Column(columnDefinition = "TEXT")
    private String mainImage;

    @Enumerated(EnumType.STRING) // 新增的 saleType 欄位，存 ENUM
    @Column(name = "sale_type", nullable = false)
    private SaleTypeEnum saleType;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();

    // 變體關聯
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<VariantsDo> variants;

    // 商品圖片關聯
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<ProductImagesDo> images;
}





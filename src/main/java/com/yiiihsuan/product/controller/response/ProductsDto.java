package com.yiiihsuan.product.controller.response;

import com.yiiihsuan.product.dao.entity.ProductImagesDo;
import com.yiiihsuan.product.dao.entity.VariantsDo;
import com.yiiihsuan.product.enums.CategoryEnum;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;


@Data
public class ProductsDto {
    private Long id;

    private String productCode; // 商家 SKU，確保唯一

    private String name;

    private String description;

    private CategoryEnum category;

    private String texture;

    private String wash;

    private String place;

    private String note;

    private String story;

    private String mainImage;

    private List<String> colors;

    private List<String> sizes;

    private List<VariantsDo> variants;

    private List<ProductImagesDo> images;


}





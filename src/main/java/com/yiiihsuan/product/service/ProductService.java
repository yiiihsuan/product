package com.yiiihsuan.product.service;


import com.yiiihsuan.product.controller.response.ProductsDto;
import com.yiiihsuan.product.dao.entity.ProductsDo;
import com.yiiihsuan.product.dao.repository.ProductsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductsRepository productsRepository;

    public List<ProductsDto> searchProducts(String keyword) {
        List<ProductsDo> products = productsRepository.searchByKeyword(keyword);

        return products.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    public ProductsDto findProductById(Long id) {
        ProductsDo product = productsRepository.findByIdWithVariants(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));

        return this.convert(product);
    }

    private ProductsDto convert(ProductsDo product) {
        List<String> colors = product.getVariants()
                .stream()
                .map(item -> item.getColor().getCode())
                .collect(Collectors.toSet())
                .stream().toList();

        List<String> sizes = product.getVariants()
                .stream()
                .map(item -> item.getSize().toString())
                .collect(Collectors.toSet())
                .stream().toList();

        ProductsDto res = new ProductsDto();

        res.setId(product.getId());
        res.setProductCode(product.getProductCode());
        res.setName(product.getName());
        res.setDescription(product.getDescription());
        res.setCategory(product.getCategory());
        res.setTexture(product.getTexture());
        res.setWash(product.getWash());
        res.setPlace(product.getPlace());
        res.setNote(product.getNote());
        res.setStory(product.getStory());
        res.setMainImage(product.getMainImage());
        res.setColors(colors);
        res.setSizes(sizes);
        res.setVariants(product.getVariants());
        res.setImages(product.getImages());

        return res;
    }

}

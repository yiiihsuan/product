package com.yiiihsuan.product.controller;


import com.yiiihsuan.product.controller.response.ProductsDto;
import com.yiiihsuan.product.dao.entity.ProductsDo;
import com.yiiihsuan.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<ProductsDto> findMemberById(@PathVariable("id") Long id) {
        try {
            // 調用 Service 層的 findMember 方法
            ProductsDto product = productService.findProductById(id);
            return ResponseEntity.ok(product); // 查詢成功，返回會員數據
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null); // 請求不合法時，返回 400
        }
    }

    @GetMapping("/search")
    public List<ProductsDto> searchProducts(@RequestParam String keyword) {
        return productService.searchProducts(keyword);
    }
}

package com.yiiihsuan.product.dao;

import com.yiiihsuan.product.dao.entity.ProductsDo;
import com.yiiihsuan.product.dao.repository.ProductsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProductTest {

    @Autowired
    private ProductsRepository productsRepository;

    @Test
    public void testRepository() {
        List<ProductsDo> data = productsRepository.findAll();

        int x = 0;
    }

}



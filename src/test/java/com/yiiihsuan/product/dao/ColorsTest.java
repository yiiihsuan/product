package com.yiiihsuan.product.dao;

import com.yiiihsuan.product.dao.entity.ColorsDo;
import com.yiiihsuan.product.dao.repository.ColorsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
public class ColorsTest {
    @Autowired
    private ColorsRepository colorsRepository;

    @Test
    public void testRepository() {
        List<ColorsDo> data = colorsRepository.findAll();
        colorsRepository.findAll().forEach(System.out::println);
    }
}


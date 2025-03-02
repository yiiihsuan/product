package com.yiiihsuan.product.dao.repository;

import com.yiiihsuan.product.dao.entity.ProductsDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;






public interface ProductsRepository extends JpaRepository<ProductsDo, Long> {

    @Query("SELECT p FROM ProductsDo p LEFT JOIN FETCH p.variants WHERE p.id = :id")
    Optional<ProductsDo> findByIdWithVariants(@Param("id") Long id);

    @Query("SELECT p FROM ProductsDo p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(p.description) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<ProductsDo> searchByKeyword(String keyword);



}



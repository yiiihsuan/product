package com.yiiihsuan.product.dao.repository;

import com.yiiihsuan.product.dao.entity.ProductsDo;
import com.yiiihsuan.product.dao.entity.VariantsDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface VariantsRepository extends JpaRepository<VariantsDo, Long> {

    @Query("SELECT p FROM ProductsDo p " +
            "LEFT JOIN FETCH p.variants v " +
            "LEFT JOIN FETCH p.images i " +
            "WHERE p.id = :id")
    Optional<VariantsDo> findByIdWithDetails(@Param("id") Long id);
}



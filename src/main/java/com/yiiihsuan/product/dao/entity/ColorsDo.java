package com.yiiihsuan.product.dao.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "colors")

public class ColorsDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @Column(nullable = false, length = 50)
    private String name; // ex. "優雅白"

    @Column(nullable = false, unique = true, length = 6)
    private String code; // ex."FFFFFF"


}

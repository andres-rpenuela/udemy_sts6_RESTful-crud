package com.codearp.application.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name="PRODUCTS")
@Builder @NoArgsConstructor @AllArgsConstructor
@Setter @Generated @ToString @EqualsAndHashCode
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private BigDecimal price;

    @Lob
    private String description;

}

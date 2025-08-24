package com.codearp.application.dtos;

import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode
public class ProductDto {

    private Long id;
    private String name;
    private BigDecimal price;
    private String description;
}

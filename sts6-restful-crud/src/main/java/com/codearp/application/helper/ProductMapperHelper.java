package com.codearp.application.helper;

import com.codearp.application.dtos.ProductDto;
import com.codearp.application.entities.Product;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

@Component
@ApplicationScope
@Slf4j
@AllArgsConstructor
public class ProductMapperHelper {

    private final ModelMapper modelMapper;

    public ProductDto toDto(@NonNull Product product){
          return modelMapper.map(product, ProductDto.class);
    }
}

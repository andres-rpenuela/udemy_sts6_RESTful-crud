package com.codearp.application.services;

import com.codearp.application.dtos.ProductDto;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<ProductDto> findAll();
    Optional<ProductDto> findById(Long id);
    ProductDto save(@NonNull ProductDto productDto);
    ProductDto update(@NonNull ProductDto productDto);
    void delete(@NonNull ProductDto productDto);
}

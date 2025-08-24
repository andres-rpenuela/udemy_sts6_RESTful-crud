package com.codearp.application.services.impl;

import com.codearp.application.advoices.exceptions.ProductException;
import com.codearp.application.dtos.ProductDto;
import com.codearp.application.entities.Product;
import com.codearp.application.helper.ProductMapperHelper;
import com.codearp.application.repositories.ProductRepository;
import com.codearp.application.services.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;

import static com.codearp.application.advoices.MessagesError.PRODUCT_NOT_FOUND;

@Service
@AllArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapperHelper productMapper;

    @Override
    @Transactional(readOnly = true)
    public List<ProductDto> findAll() {
        return productRepository.findAll().stream().map(productMapper::toDto).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ProductDto> findById(Long id) {
        if(id==null){
            return Optional.empty();
        }
        return productRepository.findById(id).map(productMapper::toDto);
    }

    @Override
    @Transactional
    public ProductDto save(@NonNull ProductDto productDto) {

        return productMapper.toDto( mapAndSaveProduct( new Product() ,productDto) );
    }

    @Override
    @Transactional
    public ProductDto update(@NonNull ProductDto productDto) {
        String error_1 = MessageFormat.format(PRODUCT_NOT_FOUND, productDto.getId() );
        Product product = productRepository.findById(productDto.getId()).orElseThrow(() -> new ProductException(error_1));

        return productMapper.toDto( mapAndSaveProduct(product,productDto) );
    }

    @Transactional(propagation = Propagation.REQUIRED)
    protected Product mapAndSaveProduct(@NonNull Product product,@NonNull ProductDto productDto){
        product.setName( productDto.getName() );
        product.setDescription( productDto.getDescription() );
        product.setPrice( productDto.getPrice() );

        return  productRepository.save(product);
    }

    @Override
    @Transactional
    public void delete(@NonNull ProductDto productDto) {
        String error_1 = MessageFormat.format(PRODUCT_NOT_FOUND, productDto.getId() );
        Product product = productRepository.findById(productDto.getId()).orElseThrow(() -> new ProductException(error_1));

        productRepository.delete(product);
    }
}

package com.test.SpringBootApi.service;

import com.test.SpringBootApi.domain.Product;
import com.test.SpringBootApi.dto.ProductRequestDto;
import com.test.SpringBootApi.dto.ProductReturnDto;

import java.util.List;

public interface ProductService {

    Product save(ProductRequestDto productRequestDto);
    ProductReturnDto findById(Long id);
    List<ProductReturnDto> findAll();
    ProductReturnDto update(Long id, ProductRequestDto productRequestDto);
    void delete(Long id);
    List<ProductReturnDto> searchProducts(String productName);

}

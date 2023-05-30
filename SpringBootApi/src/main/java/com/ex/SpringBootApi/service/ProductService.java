package com.ex.SpringBootApi.service;

import com.ex.SpringBootApi.domain.Product;
import com.ex.SpringBootApi.dto.ProductReturnDto;

import java.util.List;

public interface ProductService {

    public Product save(Product product);
    public ProductReturnDto findById(Long id);
    public Product update(Long id, Product product);
    public void delete(Long id);

    public List<ProductReturnDto> searchProducts(String productName);

}

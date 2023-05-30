package com.ex.SpringBootApi.respository;

import com.ex.SpringBootApi.domain.Product;

import java.util.List;

public interface ProductRepositoryCustom {
    List<Product> findByProductName(String name);

}

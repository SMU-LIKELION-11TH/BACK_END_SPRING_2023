package com.test.SpringBootApi.respository;

import com.test.SpringBootApi.domain.Product;
import com.test.SpringBootApi.dto.ProductReturnDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<ProductReturnDto> findByProductName(String productName);
}

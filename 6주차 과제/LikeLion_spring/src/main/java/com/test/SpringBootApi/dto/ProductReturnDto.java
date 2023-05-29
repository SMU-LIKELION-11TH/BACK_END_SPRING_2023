package com.test.SpringBootApi.dto;

import com.test.SpringBootApi.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductReturnDto {
    private Long id;
    private String productName;

    private int price;

    public ProductReturnDto(Product product) {
        this.id = product.getId();
        this.productName = product.getProductName();
        this.price = product.getPrice();
    }
}

package com.ex.SpringBootApi.dto;


import com.ex.SpringBootApi.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
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

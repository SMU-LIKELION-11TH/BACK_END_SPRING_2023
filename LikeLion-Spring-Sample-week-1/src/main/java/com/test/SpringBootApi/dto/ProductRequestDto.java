package com.test.SpringBootApi.dto;

import com.test.SpringBootApi.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDto {
    private String productName;
    private int price;

    public Product toEntity(){
        Product product = new Product(
                this.productName,
                this.price
        );
        return product;
    }
}

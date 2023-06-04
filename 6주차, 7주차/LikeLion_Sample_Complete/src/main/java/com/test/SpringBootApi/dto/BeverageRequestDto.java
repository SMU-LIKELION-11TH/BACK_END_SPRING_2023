package com.test.SpringBootApi.dto;

import com.test.SpringBootApi.domain.Beverage;
import com.test.SpringBootApi.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class BeverageRequestDto extends ProductRequestDto{

    private int volume;

    private boolean carbonated;
    @Override
    public Product toEntity() {
        Beverage beverage = new Beverage(
                this.getProductName(),
                this.getPrice(),
                this.getVolume(),
                this.isCarbonated()
        );
        return beverage;
    }
}

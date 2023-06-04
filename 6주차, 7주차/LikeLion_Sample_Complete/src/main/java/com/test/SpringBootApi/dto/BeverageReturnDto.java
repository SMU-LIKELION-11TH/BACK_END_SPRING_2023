package com.test.SpringBootApi.dto;

import com.test.SpringBootApi.domain.Beverage;
import com.test.SpringBootApi.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BeverageReturnDto extends ProductReturnDto {

    private int volume;

    private boolean carbonated;

    public BeverageReturnDto(Beverage beverage) {
        super(beverage);
        this.volume = volume;
        this.carbonated = carbonated;
    }

}

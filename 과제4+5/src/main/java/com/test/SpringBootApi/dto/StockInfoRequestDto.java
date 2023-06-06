package com.test.SpringBootApi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StockInfoRequestDto {

    private Long storeId;

    private Long productId;

    private int stockQuantity;


}

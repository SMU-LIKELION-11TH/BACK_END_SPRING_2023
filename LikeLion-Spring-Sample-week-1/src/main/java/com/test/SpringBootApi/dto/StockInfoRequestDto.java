package com.test.SpringBootApi.dto;

import com.test.SpringBootApi.domain.Store;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class StockInfoRequestDto {

    private Long storeId;

    private Long productId;

    private int stockQuantity;

}

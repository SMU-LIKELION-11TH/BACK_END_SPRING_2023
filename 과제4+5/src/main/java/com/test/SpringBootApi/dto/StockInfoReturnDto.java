package com.test.SpringBootApi.dto;

import com.test.SpringBootApi.domain.StockInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StockInfoReturnDto {

    private int stockQuantity;
    private ProductReturnDto product;
    private StoreReturnDto store;

    public StockInfoReturnDto(StockInfo stockInfo) {
        this.stockQuantity = stockInfo.getStockQuantity();
        this.product = new ProductReturnDto(stockInfo.getProduct());
        this.store = new StoreReturnDto(stockInfo.getStore());
    }
}

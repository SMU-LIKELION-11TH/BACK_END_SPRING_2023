package com.test.SpringBootApi.dto;

import com.test.SpringBootApi.domain.Product;
import com.test.SpringBootApi.domain.StockInfo;
import com.test.SpringBootApi.domain.Store;
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

    private Product product;

    private Store store;

    public StockInfoReturnDto(StockInfo stockInfo) {
        this.stockQuantity = stockInfo.getStockQuantity();
        this.product = stockInfo.getProduct();
        this.store = stockInfo.getStore();
    }

}

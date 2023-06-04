package com.test.SpringBootApi.dto;

import com.test.SpringBootApi.domain.Product;
import com.test.SpringBootApi.domain.StockInfo;
import com.test.SpringBootApi.domain.Store;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StoreReturnDto {
    private Long storeId;
    private String storeName;
    private String address;

//    private List<StockInfo> stockInfos;

    public StoreReturnDto(Store store) {
        this.storeId = store.getId();
        this.storeName = store.getStoreName();
        this.address = store.getAddress();
    }
}

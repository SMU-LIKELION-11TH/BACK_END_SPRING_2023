package com.ex.SpringBootApi.dto;

import com.ex.SpringBootApi.domain.Store;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StoreReturnDto {

    private Long storeId;
    private String storeName;
    private String address;
//
//    public StoreReturnDto(Long id, String storeName, String address) {
//        this.storeName = storeName;
//        this.address = address;
//    }
    public StoreReturnDto(Store store){
        this.storeId = store.getId();
        this.storeName = store.getStoreName();
        this.address = store.getAddress();

    }
}

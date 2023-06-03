package com.test.SpringBootApi.dto;

import com.test.SpringBootApi.domain.Store;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class StoreRequestDto {

    private String storeName;

    private String address;

    public Store toEntity(){
        return new Store(
                this.storeName,
                this.address
        );
    }

}

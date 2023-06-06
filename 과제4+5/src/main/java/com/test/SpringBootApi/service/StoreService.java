package com.test.SpringBootApi.service;

import com.test.SpringBootApi.dto.StoreRequestDto;
import com.test.SpringBootApi.dto.StoreReturnDto;

public interface StoreService {
    public StoreReturnDto save(StoreRequestDto StoreRequestDto);

    public StoreReturnDto findById(Long id);
}

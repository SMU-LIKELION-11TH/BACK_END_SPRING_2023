package com.ex.SpringBootApi.service;

import com.ex.SpringBootApi.dto.StoreRequestDto;
import com.ex.SpringBootApi.dto.StoreReturnDto;

public interface StoreService {
    public StoreReturnDto save(StoreRequestDto StoreRequestDto);

    public StoreReturnDto findById(Long id);
}

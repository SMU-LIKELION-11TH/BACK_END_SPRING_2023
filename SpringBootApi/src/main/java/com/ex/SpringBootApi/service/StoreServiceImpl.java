package com.ex.SpringBootApi.service;

import com.ex.SpringBootApi.domain.Store;
import com.ex.SpringBootApi.dto.StoreRequestDto;
import com.ex.SpringBootApi.dto.StoreReturnDto;
import com.ex.SpringBootApi.respository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreServiceImpl implements StoreService{

    @Autowired
    private StoreRepository storeRepository;
    @Override
    public StoreReturnDto save(StoreRequestDto storeRequestDto) {
        Store store = storeRequestDto.toEntity();
        store = storeRepository.save(store);

        return new StoreReturnDto(store);
    }

    @Override
    public StoreReturnDto findById(Long id) {
        Store store = storeRepository.findById(id).orElse(null);

        return new StoreReturnDto(store);

    }
}

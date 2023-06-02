package com.test.SpringBootApi.service;

import com.test.SpringBootApi.domain.StockInfo;
import com.test.SpringBootApi.domain.Store;
import com.test.SpringBootApi.dto.StockInfoReturnDto;
import com.test.SpringBootApi.dto.StoreRequestDto;
import com.test.SpringBootApi.dto.StoreReturnDto;
import com.test.SpringBootApi.respository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class StoreServiceImpl implements StoreService{
    @Autowired
    private StoreRepository storeRepository;


    @Override
    public StoreReturnDto save(StoreRequestDto storeRequestDto) {
        Store store = storeRequestDto.toEntity();
        Store _store = storeRepository.save(store);

        return new StoreReturnDto(_store);
    }

    @Override
    public StoreReturnDto findById(Long id) {
        Store store = storeRepository.findById(id).orElse(null);

        return new StoreReturnDto(store);
    }

}

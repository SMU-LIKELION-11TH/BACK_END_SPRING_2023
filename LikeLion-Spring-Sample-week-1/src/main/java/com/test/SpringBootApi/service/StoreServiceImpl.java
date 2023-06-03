package com.test.SpringBootApi.service;

import com.test.SpringBootApi.domain.Product;
import com.test.SpringBootApi.domain.Store;
import com.test.SpringBootApi.dto.ProductReturnDto;
import com.test.SpringBootApi.dto.StoreRequestDto;
import com.test.SpringBootApi.dto.StoreReturnDto;
import com.test.SpringBootApi.respository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class StoreServiceImpl implements  StoreService {

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

    public Object update(Long id, StoreRequestDto storeRequestDto) {

        try {
            Optional<Store> storeData = storeRepository.findById(id);
            if (storeData.isPresent()) {
                Store _store = storeData.get();
                _store.setStoreName(storeRequestDto.getStoreName());
                _store.setAddress(storeRequestDto.getAddress());
                return new StoreReturnDto(_store);
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    @Override
    public void delete(Long id) {
        try {
            storeRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<StoreReturnDto> findAll(){
        List<Store> storeList = storeRepository.findAll();
        List<StoreReturnDto> storeReturnDtoList = new ArrayList<>();

        return storeList.stream().map(StoreReturnDto::new).collect(Collectors.toList());
    }
}

package com.ex.SpringBootApi.controller;

import com.ex.SpringBootApi.domain.Store;
import com.ex.SpringBootApi.dto.ProductReturnDto;
import com.ex.SpringBootApi.dto.StoreRequestDto;
import com.ex.SpringBootApi.dto.StoreReturnDto;
import com.ex.SpringBootApi.service.ProductServiceImpl;
import com.ex.SpringBootApi.service.StoreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController

@RequestMapping("/api")

public class StoreController {

    @Autowired
    StoreServiceImpl storeService;

    @GetMapping("/stores/{id}")
    public ResponseEntity<StoreReturnDto> getProductById(@PathVariable("id") long id) {

        try {
            StoreReturnDto storeReturnDto = storeService.findById(id);
            return ResponseEntity.ok(storeReturnDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping("/stores")
    public ResponseEntity<StoreReturnDto> createStore(@RequestBody StoreRequestDto storeRequestDto){
        StoreReturnDto responseDto = storeService.save(storeRequestDto);

        return ResponseEntity.ok(responseDto);
    }
}

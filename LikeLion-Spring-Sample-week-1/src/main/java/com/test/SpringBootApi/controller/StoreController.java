package com.test.SpringBootApi.controller;

import com.test.SpringBootApi.domain.Product;
import com.test.SpringBootApi.domain.Store;
import com.test.SpringBootApi.dto.ProductRequestDto;
import com.test.SpringBootApi.dto.ProductReturnDto;
import com.test.SpringBootApi.dto.StoreRequestDto;
import com.test.SpringBootApi.dto.StoreReturnDto;
import com.test.SpringBootApi.service.StoreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class StoreController {

    @Autowired
    StoreServiceImpl storeService;

    @GetMapping("/stores/{id}")
    public ResponseEntity<StoreReturnDto> getStoreById(@PathVariable("id") long id) {

        try {
            return ResponseEntity.ok(storeService.findById(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping("/stores")
    public ResponseEntity<StoreReturnDto> createStores(@RequestBody StoreRequestDto storeRequestDto) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(storeService.save(storeRequestDto));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PutMapping("/stores/{id}")
    public ResponseEntity<StoreReturnDto> updateProduct(
            @PathVariable("id") long id,
            @RequestBody StoreRequestDto storeRequestDto
    ) {
        try {
            ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(storeService.update(id, storeRequestDto));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @DeleteMapping("/stores/{id}")
    public ResponseEntity<HttpStatus> deleteStore(@PathVariable("id") long id) {
        try {
            storeService.delete(id);
            ResponseEntity.noContent();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/stores")
    public ResponseEntity<List<StoreReturnDto>> getAllStore(){
        List<StoreReturnDto> storeReturDtoiList = storeService.findAll();

        return ResponseEntity.ok(storeReturDtoiList);
    }

}

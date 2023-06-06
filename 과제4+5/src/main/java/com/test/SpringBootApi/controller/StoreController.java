package com.test.SpringBootApi.controller;

import com.test.SpringBootApi.dto.StoreRequestDto;
import com.test.SpringBootApi.dto.StoreReturnDto;
import com.test.SpringBootApi.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @PostMapping("/stores")
    public ResponseEntity<StoreReturnDto> createStore(@RequestBody StoreRequestDto storeRequestDto){
        StoreReturnDto responseStore = storeService.save(storeRequestDto);

        return ResponseEntity.ok(responseStore);
    }

    @GetMapping("/stores/{id}")
    public ResponseEntity<StoreReturnDto> storeDetail(@PathVariable(value = "id")Long id){
        StoreReturnDto responseStore = storeService.findById(id);

        return ResponseEntity.ok(responseStore);
    }

}

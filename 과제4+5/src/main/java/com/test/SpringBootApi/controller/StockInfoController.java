package com.test.SpringBootApi.controller;

import com.test.SpringBootApi.dto.StockInfoRequestDto;
import com.test.SpringBootApi.dto.StockInfoReturnDto;
import com.test.SpringBootApi.service.StockInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StockInfoController {
    @Autowired
    private StockInfoService stockInfoService;

    @GetMapping("/stockinfo/{storeId}")
    public ResponseEntity<List<StockInfoReturnDto>> getStockInfo(@PathVariable Long storeId){
        List<StockInfoReturnDto> stockInfoReturnDtoList = stockInfoService.findByStoreId(storeId);

        return ResponseEntity.ok(stockInfoReturnDtoList);
    }

    @PostMapping("/stockinfo")
    public ResponseEntity<?> createStockInfo(@RequestBody StockInfoRequestDto stockInfoRequestDto) {
        stockInfoService.saveStockInfo(stockInfoRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

package com.test.SpringBootApi.controller;

import com.test.SpringBootApi.dto.BeverageReturnDto;
import com.test.SpringBootApi.service.BeverageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BeverageController {

    private final BeverageService beverageService;

    public BeverageController(BeverageService beverageService) {
        this.beverageService = beverageService;
    }

    @GetMapping("/beverage/carbonated")
    public ResponseEntity<List<BeverageReturnDto>> getCarbonatedBeverages(){
        List<BeverageReturnDto> beverages = beverageService.findCarbonated();
        return new ResponseEntity<>(beverages, HttpStatus.OK);
    }
}

package com.test.SpringBootApi.service;

import com.test.SpringBootApi.domain.Beverage;
import com.test.SpringBootApi.domain.Product;
import com.test.SpringBootApi.dto.BeverageReturnDto;
import com.test.SpringBootApi.dto.ProductRequestDto;
import com.test.SpringBootApi.dto.ProductReturnDto;
import com.test.SpringBootApi.respository.BeverageRepository;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BeverageService implements ProductService {

    private final BeverageRepository beverageRepository;

    public BeverageService(BeverageRepository beverageRepository) {
        this.beverageRepository = beverageRepository;
    }

    public List<BeverageReturnDto> findCarbonated() {
        List<Beverage> carbonatedBeverage = beverageRepository.findBeverageByCarbonatedTrue();

        return carbonatedBeverage.stream()
                .map(BeverageReturnDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public Product save(ProductRequestDto productRequestDto) {
        return null;
    }

    @Override
    public ProductReturnDto findById(Long id) {
        return null;
    }

    @Override
    public List<ProductReturnDto> findAll() {
        return null;
    }

    @Override
    public ProductReturnDto update(Long id, ProductRequestDto productRequestDto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<ProductReturnDto> searchProducts(String productName) {
        return null;
    }
}

package com.test.SpringBootApi.service;

import com.test.SpringBootApi.domain.Product;
import com.test.SpringBootApi.domain.StockInfo;
import com.test.SpringBootApi.domain.Store;
import com.test.SpringBootApi.dto.StockInfoRequestDto;
import com.test.SpringBootApi.dto.StockInfoReturnDto;
import com.test.SpringBootApi.respository.ProductRepository;
import com.test.SpringBootApi.respository.StockInfoRepository;
import com.test.SpringBootApi.respository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockInfoService {
    @Autowired
    private StockInfoRepository stockInfoRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StoreRepository storeRepository;

    public void saveStockInfo(StockInfoRequestDto stockInfoRequestDto) {
        StockInfo stockInfo = new StockInfo();

        Product product = productRepository.findById(stockInfoRequestDto.getProductId()).get();
        Store store = storeRepository.findById(stockInfoRequestDto.getStoreId()).get();

        stockInfo.setProduct(product);
        stockInfo.setStore(store);
        stockInfo.setStockQuantity(stockInfo.getStockQuantity());

        stockInfoRepository.save(stockInfo);
    }

    public List<StockInfoReturnDto> findByStoreId(Long storeId) {
        List<StockInfo> stockInfoList = stockInfoRepository.findAllByStoreId(storeId);

        List<StockInfoReturnDto> returnDtoList =
                stockInfoList.stream().map(StockInfoReturnDto::new).collect(Collectors.toList());
        return returnDtoList;
    }
}

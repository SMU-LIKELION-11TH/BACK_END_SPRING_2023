package com.test.SpringBootApi.respository;

import com.test.SpringBootApi.domain.StockInfo;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockInfoRepository extends JpaRepository<StockInfo, Long> {

    @EntityGraph(attributePaths = {"store", "product"})
    List<StockInfo> findAllByStoreId(Long storeId);

}

package com.ex.SpringBootApi.respository;

import com.ex.SpringBootApi.domain.StockInfo;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockInfoRepository extends JpaRepository<StockInfo,Long> {
    @EntityGraph(attributePaths = {"store","product"})
    List<StockInfo> findAllByStoreId(Long storeId);

}
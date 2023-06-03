package com.test.SpringBootApi.respository;

import com.test.SpringBootApi.domain.Product;
import com.test.SpringBootApi.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}

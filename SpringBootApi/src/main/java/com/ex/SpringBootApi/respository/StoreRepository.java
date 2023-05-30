package com.ex.SpringBootApi.respository;

import com.ex.SpringBootApi.domain.Product;
import com.ex.SpringBootApi.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}

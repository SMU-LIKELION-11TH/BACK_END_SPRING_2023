package com.ex.SpringBootApi.respository;

import com.ex.SpringBootApi.domain.Product;
import com.ex.SpringBootApi.domain.StockInfo;
import jakarta.persistence.TypedQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, ProductRepositoryCustom {



}
package com.ex.SpringBootApi.respository;

import com.ex.SpringBootApi.domain.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepositoryCustomImpl implements ProductRepositoryCustom{

    @Autowired
    EntityManager entityManager;
    @Override
    public List<Product> findByProductName(String name) {
        List<Product> productList = entityManager.createQuery("SELECT p FROM Product AS p",Product.class).getResultList();
        return productList;
    }
}

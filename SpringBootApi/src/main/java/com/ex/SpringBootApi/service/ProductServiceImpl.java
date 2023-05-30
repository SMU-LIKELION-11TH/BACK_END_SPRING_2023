package com.ex.SpringBootApi.service;

import com.ex.SpringBootApi.domain.Product;
import com.ex.SpringBootApi.dto.ProductReturnDto;
import com.ex.SpringBootApi.respository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
//실제 서비스 구현
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        try {
            return productRepository
                    .save(
                    new Product(
                            product.getProductName(),
                            product.getPrice()
                    )
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public ProductReturnDto findById(Long id) {
        try {
            Optional<Product> productData = productRepository.findById(id);
            if (productData.isPresent()) {
                Product product = productData.get(); //optional에서 객체를 빼내올 수 있음.
                ProductReturnDto productReturnDto = new ProductReturnDto(product);
                return productReturnDto;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public Product update(Long id, Product product) {

        try {
            Optional<Product> productData = productRepository.findById(id);
            if (productData.isPresent()) {
                Product _product = productData.get();
                _product.setProductName(product.getProductName());
                _product.setPrice(product.getPrice());
                productRepository.save(_product);
                return _product;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<ProductReturnDto> findAll(){
        List<Product> productList = productRepository.findAll();
        List<ProductReturnDto> productReturnDtoList = new ArrayList<>();
        System.out.println(productList.stream().map(ProductReturnDto::new).collect(Collectors.toList()));

//        for (Product product : productList) { //가장 쉬운방식
//            productReturnDtoList.add(new ProductReturnDto(product));
//        }
//        //좀 고급진 방식
        return productList.stream().map(ProductReturnDto::new).collect(Collectors.toList());
    }
    @Override
    public void delete(Long id) {
        try {
            productRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ProductReturnDto> searchProducts(String productName) {
        List<Product> productList = productRepository.findByProductName(productName);
        return productList.stream().map(ProductReturnDto::new).collect(Collectors.toList());
    }
}

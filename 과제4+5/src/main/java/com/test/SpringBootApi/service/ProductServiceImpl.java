package com.test.SpringBootApi.service;

import com.test.SpringBootApi.domain.Product;
import com.test.SpringBootApi.dto.ProductRequestDto;
import com.test.SpringBootApi.dto.ProductReturnDto;
import com.test.SpringBootApi.respository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product save(ProductRequestDto productRequestDto) {
        try {
            return productRepository
                    .save(
                    productRequestDto.toEntity()
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
                return new ProductReturnDto(productData.get());
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ProductReturnDto> findAll() {
        List<Product> products = productRepository.findAll();

        List<ProductReturnDto> productReturnDtoList =
                products.stream().map(product -> new ProductReturnDto(product))
                        .collect(Collectors.toList());
        return productReturnDtoList;
    }

    @Transactional
    @Override
    public ProductReturnDto update(Long id, ProductRequestDto productRequestDto) {

        try {
            Optional<Product> productData = productRepository.findById(id);
            if (productData.isPresent()) {
                Product _product = productData.get();
                _product.setProductName(productRequestDto.getProductName());
                _product.setPrice(productRequestDto.getPrice());
                return new ProductReturnDto(_product);
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
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
    public List<ProductReturnDto> searchProducts(String productName){
        try{
            List<Product> products = productRepository.findByProductName(productName);
            List<ProductReturnDto> productReturnDtoList =
                    products.stream().map(product -> new ProductReturnDto(product))
                            .collect(Collectors.toList());
            return productReturnDtoList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

package com.test.SpringBootApi.controller;

import com.test.SpringBootApi.dto.ProductRequestDto;
import com.test.SpringBootApi.dto.ProductReturnDto;
import com.test.SpringBootApi.service.ProductServiceImpl;
import com.test.SpringBootApi.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductServiceImpl productService;

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductReturnDto> getProductById(@PathVariable("id") long id) {

        try {
            return ResponseEntity.ok(productService.findById(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
//    @GetMapping("/products")
//    public ResponseEntity<List<ProductReturnDto>> getAllProduct(){
//        List<ProductReturnDto> products = productService.findAll();
//
//        return ResponseEntity.ok(products);
//    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody ProductRequestDto productRequestDto) {
        try {
           return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(productService.save(productRequestDto));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<ProductReturnDto> updateProduct(
            @PathVariable("id") long id,
            @RequestBody ProductRequestDto productRequestDto
    ) {
        try {
            ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(productService.update(id, productRequestDto));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("id") long id) {
        try {
            productService.delete(id);
            ResponseEntity.noContent();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductReturnDto>> getAllProduct(){
        List<ProductReturnDto> productReturDtoiList = productService.findAll();

        return ResponseEntity.ok(productReturDtoiList);
    }

    @GetMapping("/products/search")
    public ResponseEntity<List<ProductReturnDto>> searchProducts(@RequestParam("productName") String name){
        System.out.println(name);
        List<ProductReturnDto> productReturnDtoList = productService.searchProducts(name);

        return ResponseEntity.ok(productReturnDtoList);
    }
}

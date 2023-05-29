package com.test.SpringBootApi.controller;

import com.test.SpringBootApi.dto.ProductRequestDto;
import com.test.SpringBootApi.dto.ProductReturnDto;
import com.test.SpringBootApi.service.ProductServiceImpl;
import com.test.SpringBootApi.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    @GetMapping("/products")
    public ResponseEntity<List<ProductReturnDto>> getAllProduct(){
        List<ProductReturnDto> products = productService.findAll();

        return ResponseEntity.ok(products);
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody ProductRequestDto productRequestDto) {
        try {
            Product product = productService.save(productRequestDto);
            System.out.println(product.getProductName());
            return ResponseEntity.ok(product);
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
    @GetMapping("/products/search")
    public ResponseEntity <List<ProductReturnDto>> searchProduct(@RequestParam("productName") String productName){
        List<ProductReturnDto> products= productService.searchProduct(productName);
        return ResponseEntity.ok(products);
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

}

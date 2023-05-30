package com.ex.SpringBootApi.controller;

import com.ex.SpringBootApi.dto.ProductReturnDto;
import com.ex.SpringBootApi.service.ProductServiceImpl;
import com.ex.SpringBootApi.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//controller 프론트엔드가 요청시 가장 먼저 데이터를 처리하는 곳
@CrossOrigin("*")
@RestController



@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductServiceImpl productService;

    //@PathVariable {id} 식으로 쓸 때 필요한 annotation이다.


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
       List<ProductReturnDto> productReturnDtoList = productService.findAll();


       return ResponseEntity.ok(productReturnDtoList);

    }

    @GetMapping("/products/search")
    public ResponseEntity<List<ProductReturnDto>> searchProducts(@RequestParam("productName") String name){
        System.out.println(name);
        List<ProductReturnDto> productReturnDtoList = productService.searchProducts(name);

        return ResponseEntity.ok(productReturnDtoList);
    }




//    @GetMapping("/products/")
//    public ResponseEntity<Optional<Product>> getProductByIdQuery(
//            @RequestParam("id") long id){
//        return ResponseEntity.ok(productService.findById(id));
//    }

    //POST요청을 보낼 때 body에 요청이 담겨 가므로 그떄 필요한 것이 @RequestBody이다.
    //querystring 방식 : 주로 약간 뭐랄까 filtering 느낌
    @PostMapping("/products") //requestDto returnDto
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(productService.save(product));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable("id") long id,
            @RequestBody Product product
    ) {
        try {
            ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(productService.update(id, product));
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
}

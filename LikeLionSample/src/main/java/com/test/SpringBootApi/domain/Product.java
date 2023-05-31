package com.test.SpringBootApi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id //pk
    @GeneratedValue(strategy = GenerationType.AUTO) //table id 생성 규칙
    private Long id;
    @Column(name = "product_name")
    private String productName;

    @Column(name = "price")
    private int price;



    public Product(String productName, int price) {
        this.productName = productName;
        this.price = price;
    }

}

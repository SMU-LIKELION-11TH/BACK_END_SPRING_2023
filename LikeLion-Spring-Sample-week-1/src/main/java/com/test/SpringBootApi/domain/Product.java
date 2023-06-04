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
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @ManyToMany
//    private List<Store> stores;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "price")
    private int price;

    public Product(String productName, int price) {
        this.productName = productName;
        this.price = price;
    }

}

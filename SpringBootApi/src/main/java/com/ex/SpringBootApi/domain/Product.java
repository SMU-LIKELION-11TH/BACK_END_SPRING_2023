package com.ex.SpringBootApi.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

//import javax.persistence.*;

//DB이름 설정
@Entity
@Getter
@Setter //Entitiyclass에는 Setter를 함부로 사용하지 않음. 왠만하면 안쓰는게 좋음.
@NoArgsConstructor
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "price")
    private int price;


    public Product(String productName, int price) {
        this.productName = productName;
        this.price = price;
    }


    //private List<Store> stores;stores
}

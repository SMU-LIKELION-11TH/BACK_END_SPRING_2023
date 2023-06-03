package com.test.SpringBootApi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "store")
public class Store {
    @Id
    @Column(name = "store_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToMany(mappedBy = "stores")
//    private List<Product> products;

    @OneToMany(mappedBy = "store")
    private List<StockInfo> stockInfo;

    @Column(name = "storeName")
    private String storeName;

    @Column(name = "address")
    private String address;

    public Store(String storeName, String address) {
        this.storeName = storeName;
        this.address = address;
    }
}

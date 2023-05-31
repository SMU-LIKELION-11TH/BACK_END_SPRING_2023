package com.test.SpringBootApi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "stores")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Store {
    @Id
    @Column(name = "store_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String storeName;

    private String address;

    @JsonIgnore
    @OneToMany(mappedBy = "store")
    private List<StockInfo> stockInfo;

    public Store(String storeName, String address) {
        this.storeName = storeName;
        this.address = address;
    }
}

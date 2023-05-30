package com.ex.SpringBootApi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Table(name="stores")
public class Store {

    @Id
    @Column(name = "store_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="store_name")
    private String storeName;

    @Column(name ="address")
    private String address;

    @JsonIgnore
    @OneToMany(mappedBy = "store")
    private List<StockInfo> stockInfo;



    public Store(String storeName, String address) {
        this.storeName = storeName;
        this.address = address;
    }
}

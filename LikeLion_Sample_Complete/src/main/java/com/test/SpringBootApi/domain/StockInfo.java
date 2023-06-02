package com.test.SpringBootApi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StockInfo {
    @Id
    @Column(name = "stock_info_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @ManyToOne
    private Product product;

    @Setter
    @ManyToOne
    private Store store;

    @Setter
    private Integer StockQuantity;

    public StockInfo(Product product, Store store, Integer stockQuantity) {
        this.product = product;
        this.store = store;
        StockQuantity = stockQuantity;
    }


}

package com.test.SpringBootApi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "stockInfo")
public class StockInfo {
    @Id
    @Column(name = "stock_info_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @ManyToOne
    @Setter
    private Product product;

    @ManyToOne
    @Setter
    private Store store;

    @Setter
    private Integer StockQuantity;

    public StockInfo(Product product, Store store, Integer StockQuantity) {
        this.product = product;
        this.store = store;
        this.StockQuantity = StockQuantity;
    }
}

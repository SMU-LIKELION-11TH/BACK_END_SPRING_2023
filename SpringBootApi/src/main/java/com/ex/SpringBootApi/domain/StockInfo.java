package com.ex.SpringBootApi.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Getter
@Setter

@Table(name="stock_info")
public class StockInfo {
    @Id

    @Column(name="stock_info_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Product product;

    @ManyToOne
    private Store store;

    private Integer StockQuantity;

    public StockInfo(Long id, Product product, Store store, Integer stockQuantity) {
        this.id = id;
        this.product = product;
        this.store = store;
        StockQuantity = stockQuantity;
    }
}

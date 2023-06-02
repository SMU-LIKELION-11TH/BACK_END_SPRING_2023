package com.test.SpringBootApi.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@DiscriminatorValue("Beverage")
public class Beverage extends Product {

    @Column(name = "volume")
    private int volume;

    @Column(name = "carbonated")
    private boolean carbonated;

    public Beverage(String productName, int price, int volume, boolean carbonated) {
        super(productName, price);
        this.volume = volume;
        this.carbonated = carbonated;
    }
}

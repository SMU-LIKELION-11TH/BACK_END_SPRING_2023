package com.test.SpringBootApi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@DiscriminatorValue("Snack")
public class Snack extends Product{


    @Column(name = "flavor")
    private String flavor;

    @Column(name = "packaging")
    private String packaging;
    public Snack(String productName, int price, String flavor, String packaging) {
        super(productName, price);
        this.flavor = flavor;
        this.packaging = packaging;
    }
}

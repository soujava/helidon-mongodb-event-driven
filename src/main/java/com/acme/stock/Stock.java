package com.acme.stock;

import com.acme.Product;
import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;

@Entity
public class Stock {

    @Id
    private String productCode;

    @Column
    private Product product;

    @Column
    private int available;

    public Stock() {
    }

    public Stock(String productCode, Product product, int available) {
        this.productCode = productCode;
        this.product = product;
        this.available = available;
    }

    // getters/setters
}
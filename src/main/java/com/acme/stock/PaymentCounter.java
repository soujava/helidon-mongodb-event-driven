package com.acme.stock;

import com.acme.Product;
import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;

@Entity
public class PaymentCounter {

    @Id
    private String productCode;

    @Column
    private Product product;

    @Column
    private int available;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public PaymentCounter() {
    }

    public PaymentCounter(String productCode, Product product, int available) {
        this.productCode = productCode;
        this.product = product;
        this.available = available;
    }


}
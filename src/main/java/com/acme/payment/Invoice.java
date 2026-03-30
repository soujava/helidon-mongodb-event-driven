package com.acme.payment;

import com.acme.Product;
import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;

import java.math.BigDecimal;

@Entity
public class Invoice {

    @Id
    private String id;

    @Column
    private Product product;

    @Column
    private int quantity;

    @Column
    private BigDecimal unitPrice;

    @Column
    private BigDecimal totalAmount;

    @Column
    private String status;

    public Invoice() {
    }

    public Invoice(String id,
                   Product product,
                   int quantity,
                   BigDecimal unitPrice,
                   BigDecimal totalAmount,
                   String status) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalAmount = totalAmount;
        this.status = status;
    }
}
package com.acme.payment;

import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;

import java.math.BigDecimal;

@Entity
public class Payment {

    @Id
    private String id;

    @Column
    private String invoiceId;

    @Column
    private BigDecimal amount;

    @Column
    private PaymentStatus status;

    public Payment() {
    }

    public Payment(String id, String invoiceId, BigDecimal amount, PaymentStatus status) {
        this.id = id;
        this.invoiceId = invoiceId;
        this.amount = amount;
        this.status = status;
    }

    // getters/setters
}
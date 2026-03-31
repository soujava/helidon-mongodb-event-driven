package com.acme.stock;

import com.acme.Product;
import com.acme.infraestructure.JsonFieldStrategy;
import jakarta.json.bind.annotation.JsonbVisibility;
import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;

import java.util.UUID;

@Entity
@JsonbVisibility(JsonFieldStrategy.class)
public class PaymentCounter {

    @Id
    private UUID productCode;

    @Column
    private Product product;

    @Column
    int successfulPayments;

    @Column
    int failedPayments;

    PaymentCounter(Product product) {
        this.productCode = product.code();
        this.product = product;
    }

    PaymentCounter() {
    }

    public void failedPayments() {
        this.failedPayments++;
    }

    public void successfulPayments() {
        this.successfulPayments++;
    }
}
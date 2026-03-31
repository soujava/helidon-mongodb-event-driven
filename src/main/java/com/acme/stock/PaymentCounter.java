package com.acme.stock;

import com.acme.Product;
import com.acme.infraestructure.JsonFieldStrategy;
import jakarta.json.bind.annotation.JsonbVisibility;
import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;

@Entity
@JsonbVisibility(JsonFieldStrategy.class)
public class PaymentCounter {

    @Id
    private String productCode;

    @Column
    private Product product;

    @Column
    private int successfulPayments;

    @Column
    private int failedPayments;

    public String getProductCode() {
        return productCode;
    }

    public Product getProduct() {
        return product;
    }

    public int getSuccessfulPayments() {
        return successfulPayments;
    }

    public int getFailedPayments() {
        return failedPayments;
    }
}
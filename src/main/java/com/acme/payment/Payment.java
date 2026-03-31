package com.acme.payment;

import com.acme.Product;
import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Payment {

    @Id
    private String id;

    @Column
    private BigDecimal amount;

    @Column
    private PaymentStatus status;

    @Column
    private Product product;

    public Payment() {
    }

    public Payment(Product product, BigDecimal amount, PaymentStatus status) {
        this.id = UUID.randomUUID().toString();
        this.amount = amount;
        this.status = status;
        this.product = product;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Payment payment)) {
            return false;
        }
        return Objects.equals(id, payment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id='" + id + '\'' +
                ", amount=" + amount +
                ", status=" + status +
                ", product=" + product +
                '}';
    }
}
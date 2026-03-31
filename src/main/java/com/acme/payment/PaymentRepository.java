package com.acme.payment;

import jakarta.data.repository.BasicRepository;
import jakarta.data.repository.Repository;

@Repository
public interface PaymentRepository extends BasicRepository<Payment, String> {
}

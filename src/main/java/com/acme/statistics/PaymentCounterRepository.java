package com.acme.statistics;

import jakarta.data.repository.BasicRepository;
import jakarta.data.repository.Repository;

@Repository
public interface PaymentCounterRepository extends BasicRepository<PaymentCounter, String> {
}

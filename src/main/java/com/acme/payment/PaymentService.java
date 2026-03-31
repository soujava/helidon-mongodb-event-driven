package com.acme.payment;

import com.acme.Product;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;

import java.math.BigDecimal;

@ApplicationScoped
public class PaymentService {

    @Inject
    private PaymentRepository repository;

    @Inject
    private Event<PaymentRequestedEvent> event;

    public Payment create(PaymentRequest request) {

        Product product = new Product(
                request.productCode(),
                request.productName()
        );

        BigDecimal total = request.unitPrice()
                .multiply(BigDecimal.valueOf(request.quantity()));

        Payment payment = new Payment(
                product,
                total,
                PaymentStatus.PENDING
        );

        repository.save(payment);
        event.fire(new PaymentRequestedEvent(payment));

        return payment;
    }
}
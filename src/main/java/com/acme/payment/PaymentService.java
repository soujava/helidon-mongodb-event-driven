package com.acme.payment;

import com.acme.Product;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;

import java.math.BigDecimal;
import java.util.logging.Logger;

@ApplicationScoped
public class PaymentService {

    private static final Logger LOGGER = Logger.getLogger(PaymentService.class.getName());

    @Inject
    private PaymentRepository repository;

    @Inject
    private Event<PaymentRequestedEvent> event;

    public Payment create(PaymentRequest request) {

        LOGGER.info("Creating payment for " + request.productCode());
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
        LOGGER.info("Payment created: " + payment);
        event.fireAsync(new PaymentRequestedEvent(payment));
        return payment;
    }
}
package com.acme.payment;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;

import java.util.logging.Logger;

@ApplicationScoped
class PaymentStatusService {

    private static final Logger LOGGER = Logger.getLogger(PaymentStatusService.class.getName());

    private final PaymentRepository repository;

    @Inject
    PaymentStatusService(PaymentRepository repository) {
        this.repository = repository;
    }

    PaymentStatusService() {
        this.repository = null;
    }

    void payed(@Observes PaymentSuccessEvent event) {
        LOGGER.info("Payment " + event.payment() + " was payed");
        var payment = repository.findById(event.payment().getId()).orElseThrow();
        payment.confirmed();
        repository.save(payment);
    }

    void errorOnPayment(@Observes PaymentErrorEvent event) {
        LOGGER.info("Payment " + event.payment() + " failed");
        var payment = repository.findById(event.payment().getId()).orElseThrow();
        payment.failed();
        repository.save(payment);
    }
}

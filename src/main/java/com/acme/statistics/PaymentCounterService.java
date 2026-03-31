package com.acme.statistics;

import com.acme.Product;
import com.acme.payment.Payment;
import com.acme.payment.PaymentErrorEvent;
import com.acme.payment.PaymentSuccessEvent;
import jakarta.data.Order;
import jakarta.data.Sort;
import jakarta.data.page.Page;
import jakarta.data.page.PageRequest;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;

import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
public class PaymentCounterService {

    private static final Order<PaymentCounter> PRODUCT_CODE = Order.by(Sort.asc("productCode"));

    private static final Logger LOGGER = Logger.getLogger(PaymentCounterService.class.getName());

    private final PaymentCounterRepository repository;

    @Inject
    PaymentCounterService(PaymentCounterRepository repository) {
        this.repository = repository;
    }

    PaymentCounterService() {
        this.repository = null;
    }

    void success(@Observes PaymentSuccessEvent event) {
        LOGGER.info("Payment successful, incrementing counter");
        Payment payment = event.payment();
        Product product = payment.getProduct();
        PaymentCounter counter = repository.findById(payment.getProduct().code()).orElseGet(() -> new PaymentCounter(product));
        counter.successfulPayments();
        repository.save(counter);
    }


    void success(@Observes PaymentErrorEvent event) {
        LOGGER.info("Payment failed, incrementing counter");
        Payment payment = event.payment();
        Product product = payment.getProduct();
        PaymentCounter counter = repository.findById(payment.getProduct().code()).orElseGet(() -> new PaymentCounter(product));
        counter.failedPayments();
        repository.save(counter);
    }

    public List<PaymentCounter> findAll(PageRequest pageRequest) {
        LOGGER.info("Finding all counters, page: " + pageRequest.page());
        Page<PaymentCounter> counters = repository.findAll(pageRequest, PRODUCT_CODE);
        return counters.content();
    }
}

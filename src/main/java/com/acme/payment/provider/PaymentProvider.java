package com.acme.payment.provider;

import com.acme.payment.PaymentRequestedEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.ObservesAsync;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@ApplicationScoped
class PaymentProvider {

    private static final Logger LOGGER = Logger.getLogger(PaymentProvider.class.getName());

    private final AtomicLong counter = new AtomicLong();

    private

    void receivePayment(@ObservesAsync PaymentRequestedEvent event) {
        LOGGER.info("Processing payment: " + event.payment());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        if(counter.getAndDecrement() % 2 == 0) {
            LOGGER.warning("Payment failed: " + event.payment());

        } else {
            LOGGER.info("Payment successful: " + event.payment());
        }
        LOGGER.info("Payment processed: " + event.payment() + " - Confirmation #" + counter.incrementAndGet());
    }


}

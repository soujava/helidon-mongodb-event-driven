package com.acme.payment;

import java.math.BigDecimal;

public record PaymentRequest(String productCode,
                             String productName,
                             int quantity,
                             BigDecimal unitPrice) {
}

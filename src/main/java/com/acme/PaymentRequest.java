package com.acme;

import java.math.BigDecimal;

public record PaymentRequest(String productCode,
                             String productName,
                             int quantity,
                             BigDecimal unitPrice) {
}

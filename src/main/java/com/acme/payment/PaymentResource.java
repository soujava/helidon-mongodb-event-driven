package com.acme.payment;

import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/payments")
public class PaymentResource {


    private final PaymentService service;

    @Inject
    public PaymentResource(PaymentService service) {
        this.service = service;
    }

    PaymentResource() {
        this.service = null;
    }

    @POST
    public Response create(PaymentRequest request) {
        return Response.accepted(service.create(request)).build();
    }
}
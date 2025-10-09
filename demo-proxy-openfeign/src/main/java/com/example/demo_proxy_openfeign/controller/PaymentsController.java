package com.example.demo_proxy_openfeign.controller;

import com.example.demo_proxy_openfeign.model.Payment;
import com.example.demo_proxy_openfeign.proxy.PaymentProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PaymentsController {

    private final PaymentProxy proxy;

    @Autowired
    public PaymentsController(PaymentProxy proxy) {
        this.proxy = proxy;
    }

    @PostMapping("/pagamenti")
    public Payment createPayment(@RequestBody Payment payment) {
        // genero un requestId da inserire in un header
        String requestId = UUID.randomUUID().toString();
        // delego la chiamata al proxy
        return proxy.createPayment(requestId, payment);
    }
}

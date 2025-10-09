package com.example.demo_proxy_rest_template.controller;

import com.example.demo_proxy_rest_template.PaymentsProxy;
import com.example.demo_proxy_rest_template.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentsController {

    private final PaymentsProxy paymentsProxy;

    @Autowired
    public PaymentsController(PaymentsProxy paymentsProxy) {
        this.paymentsProxy = paymentsProxy;
    }

    @PostMapping("/pagamenti")
    public Payment createPayment(@RequestBody Payment payment) {
        return paymentsProxy.createPayment(payment);
    }
}

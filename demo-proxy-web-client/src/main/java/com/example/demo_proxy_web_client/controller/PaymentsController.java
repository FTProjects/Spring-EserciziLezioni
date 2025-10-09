package com.example.demo_proxy_web_client.controller;

import com.example.demo_proxy_web_client.model.Payment;
import com.example.demo_proxy_web_client.proxy.PaymentsProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Controller
public class PaymentsController {

    private final PaymentsProxy proxy;

    @Autowired
    public PaymentsController(PaymentsProxy proxy) {
        this.proxy = proxy;
    }

    @PostMapping("/pagamenti")
    public Mono<Payment> createPayment(@RequestBody Payment payment) {
        String requestId = UUID.randomUUID().toString();
        return proxy.createPayment(requestId, payment);
    }
}

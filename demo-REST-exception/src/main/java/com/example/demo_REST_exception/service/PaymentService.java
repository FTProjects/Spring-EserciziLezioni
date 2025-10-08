package com.example.demo_REST_exception.service;

import com.example.demo_REST_exception.exception.NotEnoughMoneyException;
import com.example.demo_REST_exception.model.dto.PaymentDetails;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public PaymentDetails processPayment() {
        // Simuliamo chge sul conto non ci siamo
        // abbastanza soldi
        throw new NotEnoughMoneyException();
    }

}

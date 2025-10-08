package com.example.demo_REST_exception.controller;

import com.example.demo_REST_exception.exception.NotEnoughMoneyException;
import com.example.demo_REST_exception.model.dto.ErrorDetails;
import com.example.demo_REST_exception.model.dto.PaymentDetails;
import com.example.demo_REST_exception.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    // <?> vuol dire che possiamo tornare qualsiasi oggetto come
    // body della risposta HTTP
    public ResponseEntity<?> makePayment() {

        // scrivo logica di controllo eccezione
        try {
            PaymentDetails paymentDetails = paymentService.processPayment();
            return ResponseEntity.ok(paymentDetails); // ok è una scorciatoia per status.OK
        } catch (NotEnoughMoneyException nemEx) {
            ErrorDetails errorDetails = new ErrorDetails();
            errorDetails.setMessage("Non ci sono abbastanza fondi...");
            return ResponseEntity.badRequest().body(errorDetails); // torniamo 400 con un messaggio di errore nel body
        }
    }

    @PostMapping("/paymentPayPal")
    public ResponseEntity<?> makePaymentPayPal() {
        try {
            PaymentDetails paymentDetails = paymentService.processPaymentPayPal();
            return ResponseEntity.ok(paymentDetails); // ok è una scorciatoia per status.OK
        } catch (NotEnoughMoneyException nemEx) {
            ErrorDetails errorDetails = new ErrorDetails();
            errorDetails.setMessage("Non ci sono abbastanza fondi...");
            return ResponseEntity.badRequest().body(errorDetails); // torniamo 400 con un messaggio di errore nel body
        }
    }


}

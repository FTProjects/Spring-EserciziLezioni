package com.example.demo_upstream_payments.controller;

import com.example.demo_upstream_payments.model.Payment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@RestController
public class PaymentsController {

    private static Logger logger = Logger.getLogger(PaymentsController.class.getName());

    private List<Payment> listaPagamenti = new ArrayList<>();

    @PostMapping("/payments")
    public ResponseEntity<Payment> createPayment(
            @RequestHeader String requestId,
            @RequestBody Payment payment
    ) {

        // loggo l'avvenuta transazione di pagamento (simula la chiamata al servizio)
        logger.info("Ricevuto pagamento con id " + requestId);
        logger.info(" - Totale pagamento = €" + payment.getAmount());

        // valorizziamo la proprietà id dell'oggetto pagamento (simulando un id tornato dal servizio)
        payment.setId(UUID.randomUUID().toString());

        listaPagamenti.add(payment);

        // torniamo la risposta HTTP al client
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("requestId", requestId) // Inserisco header con chiave "requestId"
                .body(payment); // inseriamo l'oggetto payment nel body come json

    }

    @GetMapping("/payments")
    public List<Payment> getListaPagamenti() {
        return listaPagamenti;
    }
}

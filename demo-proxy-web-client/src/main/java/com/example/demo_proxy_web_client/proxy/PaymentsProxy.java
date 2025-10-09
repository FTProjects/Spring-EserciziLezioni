package com.example.demo_proxy_web_client.proxy;

import com.example.demo_proxy_web_client.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class PaymentsProxy {

    private final WebClient webClient;

    @Value("${name.service.url}")
    private String url;

    @Autowired
    public PaymentsProxy(WebClient webClient) {
        this.webClient = webClient;
    }

    // delega della chiamata al server upstream
    public Mono<Payment> createPayment(String requestId, Payment payment) {
        return webClient
                .post() // dichiaro di voler fare una chiamata http post
                .uri(url + "/payments")// Costruzione dell'uri
                .header("requestId", requestId) // inserisco l'header richiesto dal server
                .body(Mono.just(payment), Payment.class)// Riempio il body con l'oggetto payment
                .retrieve()// chiamo il server upstream e prendo la risposta
                .bodyToMono(Payment.class); // trasformo il body della risposta in oggetto payment
    }
}

package com.example.demo_proxy_openfeign.proxy;

import com.example.demo_proxy_openfeign.model.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

// Feign client battezza il componente come client http openfeign
// url = indirizzo del server di upstream
// ${} -> prendiamo dati da application properties
@FeignClient(name = "payments", url = "${name.service.url}")
public interface PaymentProxy {

    // metodo astratto, viene implementato in automatico da OpenFeign
    @PostMapping("/payments")
    Payment createPayment(
            @RequestHeader String requestId,
            @RequestBody Payment payment
    );
}

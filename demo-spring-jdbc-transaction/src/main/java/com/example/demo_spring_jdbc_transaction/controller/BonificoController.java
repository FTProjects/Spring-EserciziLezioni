package com.example.demo_spring_jdbc_transaction.controller;

import com.example.demo_spring_jdbc_transaction.model.dto.RichiestaBonifico;
import com.example.demo_spring_jdbc_transaction.model.entity.Conto;
import com.example.demo_spring_jdbc_transaction.service.BonificoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BonificoController {

    private final BonificoService bonificoService;

    @Autowired
    public BonificoController(BonificoService bonificoService) {
        this.bonificoService = bonificoService;
    }

    @PostMapping("/bonifici")
    public void effettuaBonifico(@RequestBody RichiestaBonifico richiestaBonifico) {
        bonificoService.effettuaBonifico(
                richiestaBonifico.getIdMittente(),
                richiestaBonifico.getIdBeneficiario(),
                richiestaBonifico.getAmmontare()
        );
    }

    @GetMapping("/conti")
    public List<Conto> getAllConti(){
        return bonificoService.getAllConti();
    }
}

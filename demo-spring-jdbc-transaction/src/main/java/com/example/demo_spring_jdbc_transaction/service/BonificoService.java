package com.example.demo_spring_jdbc_transaction.service;

import com.example.demo_spring_jdbc_transaction.model.entity.Conto;
import com.example.demo_spring_jdbc_transaction.repository.ContoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BonificoService {

    private final ContoRepository contoRepository;

    @Autowired
    public BonificoService(ContoRepository contoRepository) {
        this.contoRepository = contoRepository;
    }

    // metodo che effettua un bonifico tra un mittente e un beneficiario
    // 1. recuperare conti di mittente e beneficiario
        // 1.1 TODO controllare che i conti esistano
    // 2. calcolare il nuovo saldo
        // 2.1 TODO controllare se ci sono fondi
    // 3. aggiornare i saldi di entrambi i conti
    @Transactional // crea un contesto transazionale
    public void effettuaBonifico(int idMittente, int idBeneficiario, BigDecimal ammontare) {
        Conto mittente = contoRepository.getControById(idMittente);
        Conto beneficiario = contoRepository.getControById(idBeneficiario);

        BigDecimal nuovoSaldoMittente = mittente.getSaldo().subtract(ammontare);
        BigDecimal nuovoSaldoBeneficiario = beneficiario.getSaldo().add(ammontare);

        contoRepository.aggiornaSaldo(idMittente, nuovoSaldoMittente);
        contoRepository.aggiornaSaldo(idBeneficiario, nuovoSaldoBeneficiario);
    }

    public List<Conto> getAllConti() {
        return contoRepository.getAllConti();
    }
}

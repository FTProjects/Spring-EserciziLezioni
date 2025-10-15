package com.example.demo_transfer.service;

import com.example.demo_transfer.exception.AccountNotFoundException;
import com.example.demo_transfer.model.entity.Account;
import com.example.demo_transfer.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransferService {

    private final AccountRepository accountRepository;

    @Autowired
    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void transferMoney(long idSender, long idReceiver, BigDecimal amount) {
        // recupero i due conti
        Account sender = accountRepository.findById(idSender).orElseThrow(() -> new AccountNotFoundException());

        Account receiver = accountRepository.findById(idReceiver).orElseThrow(() -> new AccountNotFoundException());

        // calcolare i nuovi saldi
        BigDecimal senderNewMount = sender.getAmount().subtract(amount);
        BigDecimal receiverNewAmount = receiver.getAmount().add(amount);

        // aggiornare il repository
        accountRepository.changeAmount(idSender, senderNewMount);
        accountRepository.changeAmount(idReceiver, receiverNewAmount);
    }

    public List<Account> findAccountByName(String name){
        return accountRepository.findAccountsByName(name);
    }

    public Iterable<Account> getAllAccounts(){
        return accountRepository.findAll();
    }
}

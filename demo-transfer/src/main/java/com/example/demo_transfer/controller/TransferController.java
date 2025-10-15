package com.example.demo_transfer.controller;

import com.example.demo_transfer.model.dto.TransferRequest;
import com.example.demo_transfer.model.entity.Account;
import com.example.demo_transfer.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransferController {

    private final TransferService transferService;

    @Autowired
    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/transfers")
    public void transferMoney(@RequestBody TransferRequest request) {
        transferService.transferMoney(
                request.getIdSender(),
                request.getIdReceiver(),
                request.getAmount()
        );
    }

    @GetMapping("/accounts")
    public Iterable<Account> getAllAccounts(@RequestParam(required = false) String name) {
        if (name == null)
            return transferService.getAllAccounts();
        else
            return transferService.findAccountByName(name);
    }
}

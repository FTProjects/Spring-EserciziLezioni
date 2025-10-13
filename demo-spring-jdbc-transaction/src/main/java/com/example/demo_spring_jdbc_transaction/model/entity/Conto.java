package com.example.demo_spring_jdbc_transaction.model.entity;

import java.math.BigDecimal;

// Entity
public class Conto {

    private int id;
    private String nome;
    private BigDecimal saldo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}

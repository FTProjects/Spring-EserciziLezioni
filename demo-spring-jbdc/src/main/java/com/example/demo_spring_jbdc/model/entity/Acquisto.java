package com.example.demo_spring_jbdc.model.entity;

import java.math.BigDecimal;

// Acquisti
public class Acquisto {

    private int id;
    private String prodotto;
    private BigDecimal prezzo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProdotto() {
        return prodotto;
    }

    public void setProdotto(String prodotto) {
        this.prodotto = prodotto;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }
}

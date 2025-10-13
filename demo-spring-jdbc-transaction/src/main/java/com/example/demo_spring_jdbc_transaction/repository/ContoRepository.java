package com.example.demo_spring_jdbc_transaction.repository;

import com.example.demo_spring_jdbc_transaction.model.entity.Conto;
import com.example.demo_spring_jdbc_transaction.repository.mapper.ContoRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class ContoRepository {

    private final JdbcTemplate jdbc;

    @Autowired
    public ContoRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // metodo che ritorna un account passato l'id
    public Conto getControById(int id) {
        String sql = "SELECT * FROM conti WHERE id = ?";
        return jdbc.queryForObject(sql, new ContoRowMapper(), id);
    }

    // metodo che torna tutti i conti
    public List<Conto> getAllConti() {
        String sql = "SELECT * FROM conti";
        return jdbc.query(sql, new ContoRowMapper());
    }

    // metodo che permette di modificare iul saldo dell'account passato il suo id
    public void aggiornaSaldo(int id, BigDecimal nuovoSaldo) {
        String sql = "UPDATE conti SET saldo = ? WHERE id = ?";
        jdbc.update(sql, nuovoSaldo, id);
    }
}

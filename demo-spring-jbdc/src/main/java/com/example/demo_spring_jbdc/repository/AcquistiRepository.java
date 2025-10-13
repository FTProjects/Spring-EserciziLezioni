package com.example.demo_spring_jbdc.repository;

import com.example.demo_spring_jbdc.model.entity.Acquisto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

// l'annotation stereotype repository crea un bean
// nel contesto di spring e fornisce funzionalità
// di data source
@Repository
public class AcquistiRepository {

    // modo d'uso data source java
    private final JdbcTemplate jdbc;

    @Autowired
    public AcquistiRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // permette di salvare un acquisto sul db
    public void salvaAcquisto(Acquisto acquisto) {
        String sql = "INSERT INTO acquisti VALUES(?,?,?)";
        jdbc.update(sql, acquisto.getId(), acquisto.getProdotto(), acquisto.getPrezzo());
    }

    // permette di recuperare tutti gli acquisti salvati sul db
    public List<Acquisto> recuperaAcquisti() {
        String sql = "SELECT * FROM acquisti";

        RowMapper<Acquisto> rowMapper = (row, i) -> {
            Acquisto acquisto = new Acquisto();
            acquisto.setId(row.getInt("id"));
            acquisto.setProdotto(row.getString("prodotto"));
            acquisto.setPrezzo(row.getBigDecimal("prezzo"));
            return acquisto;
        };

        return jdbc.query(sql, rowMapper);
    }
}

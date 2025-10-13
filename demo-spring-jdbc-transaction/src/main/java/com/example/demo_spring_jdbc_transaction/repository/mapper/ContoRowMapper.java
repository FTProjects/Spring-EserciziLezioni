package com.example.demo_spring_jdbc_transaction.repository.mapper;

import com.example.demo_spring_jdbc_transaction.model.entity.Conto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContoRowMapper implements RowMapper<Conto> {

    @Override
    public Conto mapRow(ResultSet row, int index) throws SQLException {
        Conto conto = new Conto();
        conto.setId(row.getInt("id"));
        conto.setNome(row.getString("nome"));
        conto.setSaldo(row.getBigDecimal("saldo"));
        return conto;
    }
}

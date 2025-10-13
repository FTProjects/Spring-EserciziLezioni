package com.example.demo_spring_jbdc.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class ProjectConfig {

    @Bean
    public DataSource dataSource() {
        // fornendo un bean di tipo datasource al context
        // di spring stiamo sovrascrivendo il comportamento
        // di default con uno personalizzato

        // tipo datasource che effettua pool connessioni
        HikariDataSource dataSource = new HikariDataSource();

        // fornisco stringe di connessione per il db
        dataSource.setJdbcUrl("jdbc:mysql://localhost/spring_acquisti");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        // imposto timeout di connessione al db
        dataSource.setConnectionTimeout(1000);

        return dataSource;
    }
}

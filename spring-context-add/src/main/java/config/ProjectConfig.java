package config;

import domain.Pappagallino;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

// Stabilisce che la classe è una configurazione di Spring
@Configuration
@ComponentScan("domain") // indico alla config il package dove risiedono i componenti da caricare
public class ProjectConfig {

    //Definisce un bean di pappa1
    @Bean
    Pappagallino pappa1() {
        var p = new Pappagallino();
        p.setNome("Gino");
        return p;
    }

    // Definisce un bean con un nome personalizzato pappaPippo
    @Bean(name = "pappaPippo")
    Pappagallino pappa2() {
        var p = new Pappagallino();
        p.setNome("Pino");
        return p;
    }

    @Bean
    @Primary
        // Stabilisce che il bean è quello di default
    Pappagallino pappa3() {
        var p = new Pappagallino();
        p.setNome("Mino");
        return p;
    }

    @Bean
    Pappagallino pappa4() {
        var p = new Pappagallino();
        p.setNome("Rino");
        return p;
    }
}

package config;

import domain.Gatto;
import domain.Pappagallino;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("domain")
public class ProjectConfig {

    @Bean
    public Pappagallino pappa1() {
        Pappagallino p = new Pappagallino();
        p.setNome("Koko");
        return p;
    }

    @Bean
    // al contrario di singleton ogni volta che è richiesto un bean
    // viene creata una nuova istanza
    @Scope("prototype")
    // l'istanza/e viene creata solo quando è consumata dal client (non all'inizio dell'app)
    @Lazy
    public Gatto gatto() {
        return new Gatto();
    }
}

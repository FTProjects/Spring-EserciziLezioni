package domain;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Gatto {

    private String nome = "Pepe";
    private final String id;

    public Gatto() {
        // ogni gatto che viene creato con una new
        // ha un id diverso dagli altri
        this.id = UUID.randomUUID().toString();
        System.out.println("Gatto creato con id: " + id);
    }

    @Override
    public String toString() {
        return "Gatto{" +
                "nome='" + nome + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}

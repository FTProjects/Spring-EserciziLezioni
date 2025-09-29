package domain;

import org.springframework.stereotype.Component;

// rende la classe un componente gestito da Spring
// vengono creati bean e messi nel contesto
@Component
public class Persona {

    private String nome = "Mario";

    public String getNome() {
        return nome;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "< Persona: " + nome + " >";
    }
}

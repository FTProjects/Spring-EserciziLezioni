package domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// rende la classe un componente gestito da spring
// vengono creati bean e messi nel contesto
@Component
public class Persona {

    private String nome = "Mario";

    // mettiamo l'annotation autowired per dire a Spring
    // di prendere un bean dal contesto e assegnarlo a questa proprietà
//    @Autowired
    private Pappagallino pappagallino;

    // mettiamo l'annotation autowired per dire a Spring
    // di prendere un bean dal contesto e darlo in input a questo costruttore
    @Autowired
    public Persona(Pappagallino pappagallino) {
        System.out.println("...Costruendo la persona");
        this.pappagallino = pappagallino;
    }

    public Pappagallino getPappagallino() {
        return pappagallino;
    }

    public void setPappagallino(Pappagallino pappagallino) {
        this.pappagallino = pappagallino;
    }

    public String getNome() {
        return nome;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "< Persona: " + nome + " >" + pappagallino;
    }
}
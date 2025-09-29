package main;

import config.ProjectConfig;
import domain.Gatto;
import domain.Pappagallino;
import domain.Persona;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Recupero il bean persona, controllando la sua dipendenza pappagallino
        Persona persona = context.getBean(Persona.class);
        System.out.println(persona);

        // Se voglio posso usare il costruttore per creare persone che hanno
        // pappagallino diverso da quello di default
        Pappagallino pappa = new Pappagallino();
        pappa.setNome("Dino");
        Persona nuovaPersona = new Persona(pappa);
        System.out.println(nuovaPersona);

        //
        Gatto gatto1 = context.getBean(Gatto.class);
        System.out.println(gatto1);

        Gatto gatto2 = context.getBean(Gatto.class);
        System.out.println(gatto2);
    }
}

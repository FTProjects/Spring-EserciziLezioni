package main;

import config.ProjectConfig;
import domain.Pappagallino;
import domain.Persona;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // Vuole avere un istanza di pappagallino senza doverselo creare
        // quindi chiedendolo al context di Spring

        // recupera l'oggetto context passandogli la configurazione che abbiamo creato
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // recupero un bin dal context (quello generico che, se ce ne sono diversi, è quello Primary)
        Pappagallino mioPappa = context.getBean(Pappagallino.class);
        System.out.printf("Recuperato dal context tramite default/primary = %s\n\n", mioPappa);


        // recupero tramite il nome del metodo @Bean
        Pappagallino pappa1 = context.getBean("pappa1", Pappagallino.class);
        System.out.printf("Recuperato dal context tramite nome del metodo Bean = %s\n\n", pappa1);

        // recuperato tramite il nome personalizzato sul metodo @Bean
        Pappagallino pappa2 = context.getBean("pappaPippo", Pappagallino.class);
        System.out.printf("Recuperato dal context tramite nome personalizzato = %s\n\n", pappa2);

        //recupero un bean annotato con @Component
        Persona persona = context.getBean(Persona.class);
        System.out.printf("Recuperato dal context un Bean annotato con @Component= %s\n\n", persona);


    }
}

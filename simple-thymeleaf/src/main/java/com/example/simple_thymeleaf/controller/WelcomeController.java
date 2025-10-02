package com.example.simple_thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class WelcomeController {

    @GetMapping("/welcome")
    // L'annotation request param permette di inserire una variabile in query
    // string e usarla in questo modo
    public String welcome(Model model, @RequestParam(required = false) String nome) {
        if (nome == null)
            nome = "Pino";

        // Aggiungiamo un attributo di tipo string e di valore "Pino"
        // al model. Il model viene fornito da Spring in ingresso al metodo
        // serve appunto per passare dati dal controller alla vista
        model.addAttribute("username", nome);

        //Aggiungiamo una lista di stringhe al modello
        List<String> listaTask = List.of(
                "Studiare Springboot",
                "Eseguire Stop&Code",
                "Relax");
        model.addAttribute("attivita", listaTask);

        // torno una stringa che rappresenta il nome della view
        // che vogliamo tornare al client (senza il .html)
        return "welcome";
    }

    @GetMapping("/pippo")
    public String pippo() {
        return "Ciao";
    }
}

package com.example.demo_rest_controller.controller;

import com.example.demo_rest_controller.model.Country;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {

    @GetMapping("/italy")
    // quando un metodo di un rest controller torna un oggetto
    // questo viene trasformato in json (nella risposta)
    public Country italy() {
        return Country.of("italy", 59);
    }

    @GetMapping("france")
    public Country france() {
        return Country.of("france", 66);
    }

    @GetMapping("countries")
    // se un metodo torna una collezione di oggetti,
    // la risposta conterrà un array json contenente oggetti
    public List<Country> allCountries() {
        Country c1 = Country.of("italy", 59);
        Country c2 = Country.of("france", 66);
        return List.of(c1, c2);
    }

    // Se ho bisogno di modificare lo status http della risposta
    // oppure aggiungere degli header, ritorno ResponseEntity<T>
    // il tipo T è l'oggetto che sarà inserito nel boy della richiesta
    // in formato json
    @GetMapping("/germany")
    public ResponseEntity<Country> germany() {
        Country germany = Country.of("germany", 84);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED) // settato status code a 202
                .header("continent", "europe") // aggiunti vari header
                .header("capitale", "Berlin")
                .header("favorite_food", "krauty")
                .body(germany); // riempito il body con l'oggetto da tornare
    }
}

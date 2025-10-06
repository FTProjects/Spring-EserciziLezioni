package com.example.demo_rest_controller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// con @Controller i metodi ritornano una stringa che corrisponde al nome di una view...
@Controller
public class HelloController {

    // ...a meno che non usiamo @ResponseBody
    // che indica che l'oggetto ritornato dal metodo sarà inserito nel
    // body della risposta HTTP
    @ResponseBody
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}

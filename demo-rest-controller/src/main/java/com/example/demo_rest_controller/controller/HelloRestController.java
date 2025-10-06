package com.example.demo_rest_controller.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// usando @RestController i metodi saranno automaticamente annotati
// con @ResponseBody
@RestController
@RequestMapping("/rest") // mette un prefisso comune a tutti gli endpoint
public class HelloRestController {

    // dichiariamo l'endpoint /rest-hello
    @GetMapping("/hello")
    public String hello() {
        return "hello world";
    }

    // dichiariamo l'endpoint /rest-ciao
    @GetMapping("/ciao")
    public String ciao() {
        return "ciao";
    }

}

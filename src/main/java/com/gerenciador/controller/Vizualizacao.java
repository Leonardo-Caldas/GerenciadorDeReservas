package com.gerenciador.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Vizualizacao {
    @GetMapping("/home")
    public String mostraHomePage(@RequestParam(defaultValue = "null") String nome) {
        return "home.html";
    }
}

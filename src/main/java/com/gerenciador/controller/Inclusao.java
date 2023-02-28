package com.gerenciador.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Inclusao {
    @GetMapping("/cliente/inclui")
    public String excluiCliente(@RequestParam(defaultValue = "null") String nome) {
        return "cliente.html";
    }
}

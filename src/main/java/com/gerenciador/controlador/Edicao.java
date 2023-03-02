package com.gerenciador.controller;

import com.gerenciador.dto.cliente.Cliente;
import com.gerenciador.dto.cliente.ClienteComReserva;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Edicao {
    @GetMapping("/cliente/cadastro")
    public String editaNomeCliente(Cliente novoCliente) {
        ClienteComReserva cliente = new ClienteComReserva();
        return "cliente.html";
    }
}

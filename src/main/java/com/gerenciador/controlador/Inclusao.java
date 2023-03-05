package com.gerenciador.controlador;

import com.gerenciador.dto.ClienteRequest;
import com.gerenciador.model.Cliente;
import com.gerenciador.service.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Inclusao {

    private ClienteService clienteService;
    @PostMapping("/cliente/incluir")
    public String incluiCliente(@RequestBody ClienteRequest clienteRequest) {
            Cliente novoCliente = new Cliente();
            novoCliente.setNome(clienteRequest.getNome());
            novoCliente.setEmail(clienteRequest.getEmail());
            novoCliente.setTelefone(clienteRequest.getEmail());
            novoCliente = clienteService.criarId(novoCliente);
            return novoCliente.getId();
    }
}

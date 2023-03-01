package com.gerenciador.controller;

import com.gerenciador.model.Cliente;
import com.gerenciador.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Inclusao {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/cliente")
    public String clienteIndex() {
        return "cliente";
    }

    @PostMapping("/cliente/incluir")
    public String incluirCliente(@ModelAttribute Cliente cliente, Model model){

        System.out.println(cliente.toString());

        model.addAttribute("nome", cliente.getNome());
        model.addAttribute("cpf", cliente.getCpf());
        model.addAttribute("telefone", cliente.getTelefone());

        Cliente clienteCadastrado = clienteRepository.save(cliente);

        model.addAttribute("mensagem", clienteCadastrado.getNome().concat(" cadastrado com sucesso!"));

        return "cliente_sucesso";
    }

}

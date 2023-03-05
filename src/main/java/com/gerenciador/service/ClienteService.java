package com.gerenciador.service;

import com.gerenciador.model.Cliente;
import com.gerenciador.repository.ClienteRepository;

import java.util.UUID;

public class ClienteService {

    private ClienteRepository clienteRepository;

    public Cliente criarId(Cliente cliente){
        cliente.setId(UUID.randomUUID().toString());
        return clienteRepository.save(cliente);
    }

    public Cliente obterId(String id){
        return clienteRepository.findById(id)
                .orElse(null);
    }


}

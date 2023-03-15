package com.gerenciador.service;

import com.gerenciador.model.Cliente;
import com.gerenciador.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public Cliente cadastrar(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listar(){
        List<Cliente> lista = new ArrayList<>();
        clienteRepository.findAll().forEach(lista::add);
        return lista;
    }

    public Cliente pesquisar(Integer id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public Cliente atualizar(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Cliente excluir(int id){
        Cliente cliente = clienteRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        clienteRepository.deleteById(id);
        return cliente;
    }


}
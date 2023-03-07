package com.gerenciador.controller;

import com.gerenciador.dto.cliente.ClienteRequest;
import com.gerenciador.dto.cliente.ClienteResponse;
import com.gerenciador.model.Cliente;
import com.gerenciador.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("Cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    public Integer criar(@RequestBody ClienteRequest clienteRequest){
        Cliente cliente = new Cliente();
        BeanUtils.copyProperties(clienteRequest, cliente);
        return cliente.getId();
    }

    @GetMapping("{id}")
    public ClienteResponse ler(@PathVariable Integer id){
            Cliente cliente = clienteService.obter(id);
            ClienteResponse devolver = new ClienteResponse();
            BeanUtils.copyProperties(cliente, devolver);
            return devolver;
    }

    @GetMapping
    public List<ClienteResponse> lerTudo(){
        return clienteService.listar().stream().map(cliente ->{
            ClienteResponse devolver = new ClienteResponse();
            BeanUtils.copyProperties(cliente, devolver);
            return devolver;
        }).collect(Collectors.toList());
    }

    @PutMapping("{id}")
    public ClienteResponse atualizar(@PathVariable Integer id,@RequestBody ClienteRequest clienteRequest){
        Cliente cliente = clienteService.obter(id);
        BeanUtils.copyProperties(clienteRequest, cliente);
        ClienteResponse devolver = new ClienteResponse();
        BeanUtils.copyProperties(cliente, devolver);
        return devolver;
    }

    @DeleteMapping
    public void apagar(@PathVariable Integer id){
        clienteService.excluir(id);
    }
}

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
@RequestMapping("api-cliente")
@RequiredArgsConstructor
public class ClienteController {
    private final ClienteService clienteService;
    @PostMapping
    public Integer cadastrar(@RequestBody ClienteRequest request) {
        Cliente cliente = new Cliente();
        BeanUtils.copyProperties(request, cliente);
        clienteService.cadastrar(cliente);
        return cliente.getId();
    }

    @GetMapping
    public List<ClienteResponse> listar() {
        return clienteService.listar().stream().map(cliente -> {
            ClienteResponse clienteResponse = new ClienteResponse();
            BeanUtils.copyProperties(cliente, clienteResponse);
            return clienteResponse;
        }).collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public ClienteResponse pesquisar(@PathVariable Integer id) {
        Cliente cliente = clienteService.pesquisar(id);
        ClienteResponse response = new ClienteResponse();
        BeanUtils.copyProperties(cliente, response);
        return response;
    }

    @PutMapping("{id}")
    public ClienteResponse atualizar(@PathVariable Integer id, @RequestBody ClienteRequest clienteRequest) {
        Cliente cliente = clienteService.pesquisar(id);
        BeanUtils.copyProperties(clienteRequest, cliente);
        cliente = clienteService.atualizar(cliente);
        ClienteResponse response = new ClienteResponse();
        BeanUtils.copyProperties(cliente, response);
        return response;
    }

    @DeleteMapping("{id}")
    public void excluir(@PathVariable Integer id) {
        clienteService.excluir(id);
    }
}


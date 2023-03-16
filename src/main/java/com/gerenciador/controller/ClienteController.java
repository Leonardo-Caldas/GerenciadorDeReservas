package com.gerenciador.controller;

import com.gerenciador.dto.client.ClientRequest;
import com.gerenciador.dto.client.ClientResponse;
import com.gerenciador.model.Client;
import com.gerenciador.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("client-api")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;
    @PostMapping
    public String singUp(@RequestBody ClientRequest request) {
        Client client = new Client();
        BeanUtils.copyProperties(request, client);
        clientService.singUp(client);
        return client.getUuid();
    }

    @GetMapping
    public List<ClientResponse> listAll() {
        return clientService.listAll().stream().map(client -> {
            ClientResponse clientResponse = new ClientResponse();
            BeanUtils.copyProperties(client, clientResponse);
            return clientResponse;
        }).collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public ClientResponse findByUUID(@PathVariable String uuid) {
        Client client = clientService.findByUUID(uuid);
        ClientResponse response = new ClientResponse();
        BeanUtils.copyProperties(client, response);
        return response;
    }

    @PutMapping("{id}")
    public ClientResponse updateByUUID(@PathVariable String uuid, @RequestBody ClientRequest clientRequest) {
        Client client = clientService.findByUUID(uuid);
        BeanUtils.copyProperties(clientRequest, client);
        client = clientService.update(client);
        ClientResponse response = new ClientResponse();
        BeanUtils.copyProperties(client, response);
        return response;
    }

    @DeleteMapping("{id}")
    public void deleteByUUID(@PathVariable String uuid) {
        clientService.deleteByUUID(uuid);
    }
}


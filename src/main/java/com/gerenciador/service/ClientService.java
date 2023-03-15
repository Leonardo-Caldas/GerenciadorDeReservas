package com.gerenciador.service;

import com.gerenciador.model.Client;
import com.gerenciador.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public Client singUp(Client client){
        client.setUuid(UUID.randomUUID().toString());
        return clientRepository.save(client);
    }

    public List<Client> listAll(){
        List<Client> listOfClients = new ArrayList<>();
        clientRepository.findAll().forEach(listOfClients::add);
        return listOfClients;
    }

    @NotNull
    public Client findByUUID(String uuid) {
        return clientRepository.findById(uuid).orElse(null);
    }

    @NotNull
    public Client update(Client client){
        return clientRepository.save(client);
    }

    @NotNull
    public Client deleteByUUID(String uuid){
        Client client = clientRepository.findById(uuid).orElseThrow(IllegalArgumentException::new);
        clientRepository.deleteById(uuid);
        return client;
    }


}
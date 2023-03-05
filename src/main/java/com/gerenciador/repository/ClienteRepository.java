package com.gerenciador.repository;

import com.gerenciador.model.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, String> {
}

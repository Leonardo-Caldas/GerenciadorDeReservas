package com.gerenciador.repository;

import com.gerenciador.dto.reserva.Reserva;
import com.gerenciador.model.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ReservaRepository extends CrudRepository <Reserva, Integer> {
}

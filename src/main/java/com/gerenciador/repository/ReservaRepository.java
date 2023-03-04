package com.gerenciador.repository;

import com.gerenciador.model.Reserva;
import org.springframework.data.repository.CrudRepository;

public interface ReservaRepository extends CrudRepository <Reserva, Integer> {
}

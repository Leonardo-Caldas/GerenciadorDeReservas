package com.gerenciador.repository;

import com.gerenciador.model.Booking;
import org.springframework.data.repository.CrudRepository;

public interface ReservaRepository extends CrudRepository <Booking, Integer> {
}

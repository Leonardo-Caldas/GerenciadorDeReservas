package com.gerenciador.repository;

import com.gerenciador.model.Booking;
import org.springframework.data.repository.CrudRepository;

public interface BookingRepository extends CrudRepository <Booking, String> {
}

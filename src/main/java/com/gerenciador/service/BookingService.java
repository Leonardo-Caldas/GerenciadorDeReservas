package com.gerenciador.service;


import com.gerenciador.model.Booking;
import com.gerenciador.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;

    public Booking create(Booking booking){
        booking.setUuid(UUID.randomUUID().toString());
        return  bookingRepository.save(booking);
    }

    public List<Booking> listAll(){
        List<Booking> bookings =  new ArrayList<>();
        bookingRepository.findAll().forEach(bookings::add);
        return bookings;
    }

    @NotNull
    public Booking findByUUID(String uuid){
        return bookingRepository.findById(uuid).orElse(null);
    }
    @NotNull
    public Booking updateByUUID(Booking booking){
        return bookingRepository.save(booking);
    }

    public Booking deleteByUUID(String id){
       Booking booking = bookingRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        bookingRepository.deleteById(id);
        return booking;
    }
}



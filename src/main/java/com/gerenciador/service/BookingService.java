package com.gerenciador.service;


import com.gerenciador.model.Booking;
import com.gerenciador.repository.ReservaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReservaService {

    private final ReservaRepository reservaRepository;

    public Booking createBooking(Booking booking){
        booking.setUuid(UUID.randomUUID().toString());
        return  reservaRepository.save(booking);
    }

    public List<Booking>listarReservas(){
        List<Booking> listaBooking =  new ArrayList<>();
        reservaRepository.findAll().forEach(listaBooking::add);
        return listaBooking;
    }

    public Booking pesquisa(Integer id){
        return reservaRepository.findById(id).orElse(null);
    }

    public Booking atualizar(Booking booking){
        return reservaRepository.save(booking);
    }

    public Booking excluir(Integer id){
       Booking booking = reservaRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        reservaRepository.deleteById(id);
        return booking;
    }
}



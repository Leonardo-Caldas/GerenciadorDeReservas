package com.gerenciador.service;


import com.gerenciador.model.Reserva;
import com.gerenciador.repository.ReservaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservaService {

    private final ReservaRepository reservaRepository;

    public Reserva cadastra(Reserva reserva){
        return  reservaRepository.save(reserva);
    }

    public List<Reserva>listarReservas(){
        List<Reserva> listaReserva =  new ArrayList<>();
        reservaRepository.findAll().forEach(listaReserva::add);
        return listaReserva;
    }

    public Reserva pesquisa(Integer id){
        return reservaRepository.findById(id).orElse(null);
    }

    public Reserva atualizar(Reserva reserva){
        return reservaRepository.save(reserva);
    }

    public Reserva excluir(Integer id){
       Reserva reserva = reservaRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        reservaRepository.deleteById(id);
        return reserva;
    }
}



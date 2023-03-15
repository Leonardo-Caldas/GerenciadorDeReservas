package com.gerenciador.controller;

import com.gerenciador.dto.reserva.ReservaRequest;
import com.gerenciador.dto.reserva.ReservaResponse;
import com.gerenciador.model.Booking;
import com.gerenciador.service.ReservaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api-reserva")
@RequiredArgsConstructor
public class ReservaController {

    private final ReservaService reservaService;

    @PostMapping
    public Integer cadastrarReserva(@Valid @RequestBody ReservaRequest reservaRequest){
        Booking booking = new Booking();
        //BeanUtils.copyProperties(reservaRequest, reserva);
        booking.setDataMarcada(LocalDate.parse(reservaRequest.getDataMarcada()));
        booking.setHoraMarcada(LocalTime.parse(reservaRequest.getHoraMarcada()));
        reservaService.createBooking(booking);
        return booking.getId();
    }
    @GetMapping
    public ReservaResponse pesquisarReserva(@PathVariable Integer id){
        Booking booking = reservaService.pesquisa(id);
        ReservaResponse reservaResponse = new ReservaResponse();
        BeanUtils.copyProperties(booking, reservaResponse);
        return reservaResponse;
    }
    @GetMapping("{id}")
    public List<ReservaResponse> listarTodos(){
        return reservaService.listarReservas().stream().map(booking -> {
            ReservaResponse reservaResponse = new ReservaResponse();
            BeanUtils.copyProperties(booking, reservaResponse);
            return reservaResponse;
        }).collect(Collectors.toList());
    }

    @PutMapping("{id}")
    public ReservaResponse alterarReserva(@Valid @PathVariable Integer id, @RequestBody ReservaRequest reservaRequest){
        Booking booking = reservaService.pesquisa(id);
        BeanUtils.copyProperties(reservaRequest, booking);
        booking = reservaService.atualizar(booking);
        ReservaResponse reservaResponse = new ReservaResponse();
        BeanUtils.copyProperties(booking, reservaResponse);
        return reservaResponse;
    }

    @DeleteMapping("{id}")
    public void deletarReserva(@PathVariable Integer id){
        Booking booking = reservaService.excluir(id);
    }
}

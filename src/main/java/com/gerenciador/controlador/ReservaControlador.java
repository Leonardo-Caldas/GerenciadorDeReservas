package com.gerenciador.controller;

import com.gerenciador.dto.reserva.Reserva;
import com.gerenciador.dto.reserva.ReservaResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("reserva")
public class ReservaController {
    @PostMapping
    public void create(@RequestBody Reserva request) {
        Reserva reserva = new Reserva();
        reserva.setTemReserva(request.getTemReserva());
        reserva.setDataDaReserva(request.getDataDaReserva());
        reserva.setClienteAssociado(request.getClienteAssociado());
    }
    @GetMapping
    public ReservaResponse read(String id) {
        return new ReservaResponse();
    }
    @PutMapping
    public ReservaResponse update(String id, Reserva reservaRequest) {
        return new ReservaResponse();
    }
    @DeleteMapping
    public void delete(String id) {

    }
}

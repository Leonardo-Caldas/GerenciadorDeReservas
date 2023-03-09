package com.gerenciador.controller;

import com.gerenciador.dto.reserva.ReservaRequest;
import com.gerenciador.dto.reserva.ReservaResponse;
import com.gerenciador.model.Cliente;
import com.gerenciador.model.Reserva;
import com.gerenciador.repository.ReservaRepository;
import com.gerenciador.service.ClienteService;
import com.gerenciador.service.ReservaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api-reserva")
@RequiredArgsConstructor
public class ReservaController {

    private final ReservaService reservaService;

    @PostMapping
    public Integer cadastrarReserva(@Valid @RequestBody ReservaRequest reservaRequest){
        Reserva reserva = new Reserva();
        BeanUtils.copyProperties(reservaRequest, reserva);
        reservaService.cadastra(reserva);
        return reserva.getId();
    }
    @GetMapping
    public ReservaResponse pesquisarReserva(@PathVariable Integer id){
        Reserva reserva = reservaService.pesquisa(id);
        ReservaResponse reservaResponse = new ReservaResponse();
        BeanUtils.copyProperties(reserva, reservaResponse);
        return reservaResponse;
    }
    @GetMapping("{id}")
    public List<ReservaResponse> listarTodos(){
        return reservaService.listarReservas().stream().map(reserva -> {
            ReservaResponse reservaResponse = new ReservaResponse();
            BeanUtils.copyProperties(reserva , reservaResponse);
            return reservaResponse;
        }).collect(Collectors.toList());
    }

    @PutMapping("{id}")
    public ReservaResponse alterarReserva(@Valid @PathVariable Integer id, @RequestBody ReservaRequest reservaRequest){
        Reserva reserva = reservaService.pesquisa(id);
        BeanUtils.copyProperties(reservaRequest, reserva);
        reserva = reservaService.atualizar(reserva);
        ReservaResponse reservaResponse = new ReservaResponse();
        BeanUtils.copyProperties(reserva, reservaResponse);
        return reservaResponse;
    }

    @DeleteMapping("{id}")
    public void deletarReserva(@PathVariable Integer id){
        Reserva reserva = reservaService.excluir(id);
    }
}

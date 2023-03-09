package com.gerenciador.dto.reserva;

import lombok.Data;

import java.time.LocalTime;

@Data
public class ReservaRequest {
    private Integer numeroDeAcompanhantes;
    private String dataMarcada;
    private LocalTime horaMarcada;
    private Integer idCliente;
}

package com.gerenciador.dto.reserva;

import lombok.Data;

import java.time.LocalTime;

@Data
public class ReservaRequest {
    private Integer numeroDeAcompanhantes;
    private String dataMarcada;
    private String horaMarcada;
    private Integer idCliente;
}

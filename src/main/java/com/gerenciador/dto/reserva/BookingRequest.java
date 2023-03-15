package com.gerenciador.dto.reserva;

import lombok.Data;


@Data
public class ReservaRequest {
    private Integer numeroDeAcompanhantes;
    private String dataMarcada;
    private String horaMarcada;
    private String uuidCliente;
}

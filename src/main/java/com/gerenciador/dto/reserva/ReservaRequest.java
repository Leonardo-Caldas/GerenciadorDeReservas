package com.gerenciador.dto.reserva;

import lombok.Data;

@Data
public class ReservaRequest {
    private Integer numeroDeAcompanhantes;

    private String dataMarcada;

    private Integer idCliente;
}

package com.gerenciador.dto.reserva;

import lombok.Data;

@Data
public class ReservaResponse {

    private Integer id;

    private Integer numeroDeAcompanhantes;

    private String dataMarcada;

    private Integer idCliente;
}

package com.gerenciador.dto.reserva;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ReservaResponse {

    private Integer id;

    @NotNull
    private Integer numeroDeAcompanhantes;
    @NotEmpty
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private String dataMarcada;

    @NotEmpty
    @DateTimeFormat(pattern = "hh:mm")
    private String horaMarcada;

    private Integer idCliente;
}

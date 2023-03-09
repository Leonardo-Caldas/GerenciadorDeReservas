package com.gerenciador.dto.reserva;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalTime;
@Data
public class ReservaResponse {

    private Integer id;

    @NotNull
    @Size(min=1, max=8, message="O número máximo de ocupantes por mesa é 8!")
    private Integer numeroDeAcompanhantes;
    @NotEmpty
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @FutureOrPresent
    private String dataMarcada;

    @NotEmpty
    @DateTimeFormat(pattern = "hh:mm")
    @Future
    private LocalTime horaMarcada;

    @NotNull
    private Integer idCliente;
}

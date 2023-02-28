package com.gerenciador.dto.cliente;

import lombok.Data;

@Data
public class ClienteComReserva implements Cliente {
    Double numeroDeAcompanhantes = null;
}

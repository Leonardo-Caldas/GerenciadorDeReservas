package com.gerenciador.dto.cliente;

import lombok.Data;

@Data
public class Cliente {
    String nome = null;
    String CPF = null;
    String telefone = null;
    Double numeroDeAcompanhantes = null;
}

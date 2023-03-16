package com.gerenciador.dto.cliente;

import lombok.Data;

@Data
public class ClienteResponse {

    private Integer id;

    private String nome;

    private String telefone;

    private String email;
}

package com.gerenciador.dto.cliente;

import lombok.Data;

@Data
public class ClientRequest {
    private String name;
    private String contactNumber;
    private String email;
}

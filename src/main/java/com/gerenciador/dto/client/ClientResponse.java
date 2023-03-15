package com.gerenciador.dto.cliente;

import lombok.Data;

@Data
public class ClientResponse {
    private String uuid;
    private String name;
    private String contactNumber;
    private String email;
}

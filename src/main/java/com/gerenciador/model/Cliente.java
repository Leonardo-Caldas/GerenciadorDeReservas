package com.gerenciador.model;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class ClienteResponse {
    @Id
    private String uuid;
    private String nome = null;
    private String email = null;
    private Integer telefone = null;
    private LocalDateTime dataDaReserva = null;
    private LocalDateTime data = null;
}

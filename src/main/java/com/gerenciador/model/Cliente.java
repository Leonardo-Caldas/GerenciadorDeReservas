package com.gerenciador.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Cliente {
    @Id
    private String id;
    @Column
    private String nome;
    @Column
    private String email;
    @Column
    private String telefone;

}

package com.gerenciador.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.id.UUIDGenerator;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
public class Cliente {

    // primary key
    @Id
    private String uuid;

    private String nome;

    private String telefone;

    private String email;


}

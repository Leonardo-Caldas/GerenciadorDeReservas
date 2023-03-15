package com.gerenciador.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Generated;
import org.hibernate.id.UUIDGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@ToString
public class Reserva {


    @Id
    private String uuid;
    private Integer numeroDeAcompanhantes;
    private LocalDate dataMarcada;
    private LocalTime horaMarcada;
    private Integer idCliente;


}

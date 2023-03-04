package com.gerenciador.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reserva")
public class Reserva {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Getter
    @Setter
    @Column(name="NUMERO_DE_ACOMPANHANTES")
    private Integer numeroDeAcompanhantes = null;
    @Getter
    @Setter
    @Column(name="DATA_RESERVA")
    private LocalDateTime dataDaReserva = null;
    @Getter
    @Setter
    @Column(name="UUID_CLIENTE")
    private String clienteAssociado;

    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id + '\'' +
                ", dataDaReserva=" + dataDaReserva + '\'' +
                ", clienteAssociado=" + '\'' +
                '}';

    }
}

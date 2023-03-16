package com.gerenciador.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
public class Booking {
    @Id
    private String uuid;
    private Integer numberOfAttendees;
    private LocalDateTime appointmentTimeStamp;
    private Integer uuidClient;

}

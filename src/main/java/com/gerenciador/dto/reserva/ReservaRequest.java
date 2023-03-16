package com.gerenciador.dto.reserva;

import lombok.Data;


@Data
public class BookingRequest {
    private Integer numberOfAttendees;
    private String appointmentTimeStamp;
    private String clientUUID;
}

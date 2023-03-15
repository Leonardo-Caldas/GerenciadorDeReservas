package com.gerenciador.dto.reserva;

import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.LocalDate;
@Data
public class BookingResponse {

    private String uuid;

    @NotNull
    @Size(min=1, max=8, message="O número máximo de ocupantes por mesa é 8!")
    private Integer numberOfAttendees;
    @NotNull
    @FutureOrPresent
    private LocalDateTime appointmentTimeStamp;

    @NotNull
    private String clientUUID;
}

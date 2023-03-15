package com.gerenciador.controller;

import com.gerenciador.dto.reserva.BookingRequest;
import com.gerenciador.dto.reserva.BookingResponse;
import com.gerenciador.model.Booking;
import com.gerenciador.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("booking-api")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public String create(@Valid @RequestBody BookingRequest bookingRequest){
        Booking booking = new Booking();
        //BeanUtils.copyProperties(reservaRequest, reserva);
        booking.setAppointmentTimeStamp(LocalDateTime.parse(bookingRequest.getAppointmentTimeStamp()));
        bookingService.create(booking);
        return booking.getUuid();
    }
    @GetMapping
    public BookingResponse findByUUID(@PathVariable String uuid){
        Booking booking = bookingService.findByUUID(uuid);
        BookingResponse bookingResponse = new BookingResponse();
        BeanUtils.copyProperties(booking, bookingResponse);
        return bookingResponse;
    }
    @GetMapping("{id}")
    public List<BookingResponse> listAllBookings(){
        return bookingService.listAll().stream().map(booking -> {
            BookingResponse bookingResponse = new BookingResponse();
            BeanUtils.copyProperties(booking, bookingResponse);
            return bookingResponse;
        }).collect(Collectors.toList());
    }
    @PutMapping("{id}")
    public BookingResponse updateByUUID(@Valid @PathVariable String uuid, @RequestBody BookingRequest bookingRequest){
        Booking booking = bookingService.findByUUID(uuid);
        BeanUtils.copyProperties(bookingRequest, booking);
        booking = bookingService.updateByUUID(booking);
        BookingResponse bookingResponse = new BookingResponse();
        BeanUtils.copyProperties(booking, bookingResponse);
        return bookingResponse;
    }
    @DeleteMapping("{id}")
    public void deleteByUUID(@PathVariable String uuid){
        Booking booking = bookingService.deleteByUUID(uuid);
    }
}

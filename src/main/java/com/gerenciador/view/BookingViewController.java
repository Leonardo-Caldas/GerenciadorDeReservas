package com.gerenciador.view;

import com.gerenciador.controller.ClientController;
import com.gerenciador.controller.BookingController;
import com.gerenciador.dto.reserva.BookingRequest;
import com.gerenciador.dto.reserva.BookingResponse;
import com.gerenciador.model.Booking;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("/booking")
public class BookingViewController {
    private final BookingController bookingController;
    private final ClientController clientController;

    @RequestMapping(value = {"/main"})
    public String mostarReservas(Model model) {
        model.addAttribute("bookings", bookingController.listAllBookings());
        return "booking-main";
    }
    @GetMapping("reserva-excluir/{id}")
    public String reservaExcluir(@PathVariable("id") String uuid, Model model) {
        BookingResponse bookingResponse = bookingController.findByUUID(uuid);
        model.addAttribute("reserva", bookingResponse);
        return "delete-booking";
    }
    @PostMapping("/excluir-reserva/{id}")
    public String excluirReserva(@PathVariable("id") String uuid) {
        bookingController.deleteByUUID(uuid);
        return "redirect:/reservas";
    }
    @GetMapping("/create/{idCliente}")
    public String criarReserva(@PathVariable("idCliente") String clientUUID, Model model, BookingResponse bookingResponse) {
        model.addAttribute("client", clientUUID);
        model.addAttribute("booking", bookingResponse);
        return "create-booking";
    }
    @PostMapping("/reserva-add/{id}")
    public String adicionarReserva(@PathVariable ("id") String clientUUID, BookingRequest bookingRequest, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        try{
            bookingRequest.setClientUUID(clientUUID);
            bookingController.create(bookingRequest);
            redirectAttributes.addFlashAttribute("mensagem", String.format("Reserva marcada para a data %s com sucesso!", bookingRequest.getAppointmentTimeStamp()));
        } catch (Exception e){
            redirectAttributes.addFlashAttribute("mensagem", e.getMessage());
        }
        return "redirect:/reservas";
    }
    @GetMapping("/reserva-editar/{id}")
    public String reservaEditar(@PathVariable("id") String uuid, Model model) {
        BookingResponse bookingResponse = bookingController.findByUUID(uuid);
        model.addAttribute("cliente", clientController.findByUUID(bookingResponse.getClientUUID()));
        model.addAttribute("reserva", bookingResponse);
        return "edit-booking";
    }
    @PostMapping("/reserva-gravar/{id}")
    public String atualizarReserva(@PathVariable("id") String uuid, Booking booking,
                                   BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            booking.setUuid(uuid);
            return "edit-booking";
        }
        BookingRequest bookingRequest = new BookingRequest();
        BeanUtils.copyProperties(booking, bookingRequest);
        bookingController.updateByUUID(booking.getUuid(), bookingRequest);
        return "redirect:/reservas";
    }
}

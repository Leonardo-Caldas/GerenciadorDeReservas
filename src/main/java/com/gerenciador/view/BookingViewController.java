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
public class ReservaViewController {
    private final BookingController bookingController;
    private final ClientController clientController;

    @RequestMapping(value = {"/reservas"})
    public String mostarReservas(Model model) {
        model.addAttribute("reservas", bookingController.listAllBookings());
        return "reservas";
    }
    @GetMapping("reserva-excluir/{id}")
    public String reservaExcluir(@PathVariable("id") Integer id, Model model) {
        BookingResponse bookingResponse = bookingController.pesquisarReserva(id);
        model.addAttribute("reserva", bookingResponse);
        return "reserva-excluir";
    }
    @PostMapping("/excluir-reserva/{id}")
    public String excluirReserva(@PathVariable("id") Integer id) {
        bookingController.deletarReserva(id);
        return "redirect:/reservas";
    }
    @GetMapping("/reserva-mostrar-criar/{idCliente}")
    public String criarReserva(@PathVariable("idCliente") Integer idCliente, Model model, BookingResponse bookingResponse) {
        model.addAttribute("cliente", idCliente);
        model.addAttribute("reserva", bookingResponse);
        return "reserva-criar";
    }

    @PostMapping("/reserva-add/{id}")
    public String adicionarReserva(@PathVariable ("id") Integer idCliente, BookingRequest reserva, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        try{
            reserva.setIdCliente(idCliente);
            bookingController.cadastrarReserva(reserva);
            redirectAttributes.addFlashAttribute("mensagem", String.format("Reserva marcada para o dia %s com sucesso!", reserva.getDataMarcada()));
        } catch (Exception e){
            redirectAttributes.addFlashAttribute("mensagem", e.getMessage());
        }
        return "redirect:/reservas";
    }
    @GetMapping("/reserva-editar/{id}")
    public String reservaEditar(@PathVariable("id") Integer id, Model model) {
        BookingResponse bookingResponse = bookingController.pesquisarReserva(id);
        model.addAttribute("cliente", clientController.pesquisar(bookingResponse.getIdCliente()));
        model.addAttribute("reserva", bookingResponse);
        return "reserva-editar";
    }
    @PostMapping("/reserva-gravar/{id}")
    public String atualizarReserva(@PathVariable("id") Integer id, Booking booking,
                                   BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            booking.setId(id);
            return "reserva-editar";
        }
        BookingRequest bookingRequest = new BookingRequest();
        BeanUtils.copyProperties(booking, bookingRequest);
        bookingController.alterarReserva(booking.getId(), bookingRequest);
        return "redirect:/reservas";
    }
}

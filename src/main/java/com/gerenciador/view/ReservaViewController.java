package com.gerenciador.view;

import com.gerenciador.controller.ReservaController;
import com.gerenciador.dto.reserva.ReservaRequest;
import com.gerenciador.dto.reserva.ReservaResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class ReservaViewController {
    private final ReservaController reservaController;

    @RequestMapping(value = {"/reservas"})
    public String mostarReservas(Model model) {
        model.addAttribute("reservas", reservaController.listarTodos());
        return "reservas";
    }

    @PostMapping(value={"reservas-add"})
    public String adicionarReserva(@Valid ReservaResponse reserva, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "info-reserva";
        }
        ReservaRequest reservaRequest = new ReservaRequest();
        BeanUtils.copyProperties(reserva, reservaRequest);
        reservaController.cadastrarReserva(reservaRequest);
        return "redirect:/reservas";
    }
}

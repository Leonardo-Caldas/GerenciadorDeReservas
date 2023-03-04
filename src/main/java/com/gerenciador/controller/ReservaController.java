package com.gerenciador.controller;

import com.gerenciador.model.Reserva;
import com.gerenciador.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReservaController {
    @Autowired
    private ReservaRepository reservaRepository;

    @GetMapping("/reserva")
    public String clienteIndex() {
        return "cliente";
    }

    @PostMapping("/reserva/incluir")
    public String incluirReserva(@ModelAttribute Reserva reserva, Model model) {
        System.out.println(reserva.toString());

        model.addAttribute("dataDaReserva", reserva.getDataDaReserva());
        model.addAttribute("clienteAssociado", reserva.getClienteAssociado());

        Reserva reservaCadastrada = reservaRepository.save(reserva);
        return "reserva-sucesso";
    }
}

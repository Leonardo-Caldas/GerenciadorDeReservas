package com.gerenciador.view;

import com.gerenciador.controller.ReservaController;
import com.gerenciador.dto.reserva.ReservaRequest;
import com.gerenciador.dto.reserva.ReservaResponse;
import com.gerenciador.model.Reserva;
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
    @GetMapping("/reserva-editar/{id}")
    public String reservaEditar(@PathVariable("id") Integer id, Model model) {
        ReservaResponse reservaResponse = reservaController.pesquisarReserva(id);
        model.addAttribute("reserva", reservaResponse);
        return "reserva-editar";
    }
    @GetMapping("reservas-excluir/{id}")
    public String reservaExcluir(@PathVariable("id") Integer id, Model model) {
        ReservaResponse reservaResponse = reservaController.pesquisarReserva(id);
        model.addAttribute("reserva", reservaResponse);
        return "reserva-exlcuir";
    }
    @PostMapping("/excluir-reserva/{id}")
    public String excluirReserva(@PathVariable("id") Integer id) {
        reservaController.deletarReserva(id);
        return "redirect:/reservas";
    }
    @GetMapping("/reserva-mostrar-criar/{idCliente}")
    public String criarReserva(@PathVariable("idCliente") Integer idCliente, Model model, ReservaResponse reservaResponse) {
        model.addAttribute("cliente", idCliente);
        model.addAttribute("reserva", reservaResponse);
        System.out.println("Agora vai");
        return "reserva-criar";
    }

    @PostMapping("/reserva-add/{id}")
    public String adicionarReserva(@PathVariable ("id") Integer idCliente, ReservaRequest reserva, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        try{
            reserva.setIdCliente(idCliente);
            System.out.println(reserva.toString());
            reservaController.cadastrarReserva(reserva);
            redirectAttributes.addFlashAttribute("mensagem", String.format("Reserva marcada para o dia %s com sucesso!", reserva.getDataMarcada()));
        } catch (Exception e){
            redirectAttributes.addFlashAttribute("mensagem", e.getMessage());
        }
        /*if (result.hasErrors()) {
            return "reserva-editar";
        }

         */

        return "redirect:/reservas";
    }
    @PostMapping("/reserva-gravar/{id}")
    public String atualizarReserva(@PathVariable("id") Integer id, Reserva reserva,
                                   BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            reserva.setId(id);
            return "reserva-editar";
        }
        ReservaRequest reservaRequest = new ReservaRequest();
        BeanUtils.copyProperties(reserva, reservaRequest);
        reservaController.alterarReserva(reserva.getId(), reservaRequest);
        return "redirect:/reservas";
    }

}

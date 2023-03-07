package com.gerenciador.view;

import com.gerenciador.controller.ClienteController;
import com.gerenciador.dto.cliente.ClienteRequest;
import com.gerenciador.model.Cliente;
import com.gerenciador.service.ClienteService;
import lombok.RequiredArgsConstructor;
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
public class ClienteViewController {

    private final ClienteService clienteService;
    private final ClienteController clienteController;

    @RequestMapping(value = {"/cliente"})
    public String index(Model model) {
        model.addAttribute("clientes", clienteService.listar());
        return "cliente";
    }

    /*
    @GetMapping("/novo-cliente")
    public String showNovoComodo(Cliente cliente) {
        return "comodo-create";
    }

    @GetMapping("/comodo-edit/{id}")
    public String showEditComodo(@PathVariable("id") String id, Model model) {
        Cliente comodo = clienteService.obter(id);
        model.addAttribute("comodo", comodo);
        return "comodo-update";
    }

    @GetMapping("/comodo-delete/{id}")
    public String showDeleteComodo(@PathVariable("id") String id, Model model) {
        Comodo comodo = clienteService.obter(id);
        model.addAttribute("comodo", comodo);
        return "comodo-excluir";
    }
    */
    @GetMapping("/cliente-excluir/{id}")
    public String excluirCliente(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        try {
            clienteController.excluir(id);
            redirectAttributes.addFlashAttribute("mensagem", String.format("Cliente ID - %s excluído com sucesso!", id));
        } catch (Exception e){
            redirectAttributes.addFlashAttribute("mensagem", e.getMessage());
        }

        return "redirect:/cliente";
    }

    @PostMapping("/cliente-add")
    public String addCliente(Cliente cliente, BindingResult result, Model model, RedirectAttributes redirectAttributes) {

        try{
            clienteService.cadastrar(cliente);
            redirectAttributes.addFlashAttribute("mensagem", String.format("Cliente %s cadastrado com sucesso!", cliente.getNome()));
        } catch (Exception e){
            redirectAttributes.addFlashAttribute("mensagem", e.getMessage());
        }

        return "redirect:/cliente";
    }

    @PostMapping("/cliente-gravar/{id}")
    public String atualizarCliente(@PathVariable("id") Integer id, Cliente cliente,
                               BindingResult result, Model model, RedirectAttributes redirectAttributes) {

        try{
            /*
        if (result.hasErrors()) {
            cliente.setId(id);
            return "comodo-update";
        }

         */
            ClienteRequest clienteRequest = new ClienteRequest();
            clienteRequest.setNome(cliente.getNome());
            clienteRequest.setTelefone(cliente.getTelefone());
            clienteRequest.setEmail(cliente.getEmail());

            clienteController.atualizar(cliente.getId(), clienteRequest);

            redirectAttributes.addFlashAttribute("mensagem", String.format("Cliente %s atualizado com sucesso!", cliente.getNome()));
        } catch (Exception e){
            redirectAttributes.addFlashAttribute("mensagem", e.getMessage());
        }

        return "redirect:/cliente";
    }

}

package com.gerenciador.view;

import com.gerenciador.controller.ClientController;
import com.gerenciador.dto.client.ClientRequest;
import com.gerenciador.dto.client.ClientResponse;
import com.gerenciador.model.Client;
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
@RequestMapping("/client")
public class ClientViewController {
    private final ClientController clientController;

    @RequestMapping(value = {"/main"})
    public String index(Model model) {
        model.addAttribute("clients", clientController.listAll());
        return "client-main";
    }
    @GetMapping("/client-edit/{id}")
    public String updateClientbyUUID(@PathVariable("id") String uuid, Model model) {
        ClientResponse client = clientController.findByUUID(uuid);
        model.addAttribute("client", client);
        return "client-main";
    }

    @GetMapping("/client-excluir/{id}")
    public String deleteClientByUUID(@PathVariable("id") String uuid, Model model) {
        ClientResponse client = clientController.findByUUID(uuid);
        model.addAttribute("client", client);
        return "client-excluir";
    }

    @PostMapping("/excluir/{id}")
    public String deleteClientByUUID(@PathVariable("id") String uuid, RedirectAttributes redirectAttributes) {
        try {
            clientController.deleteByUUID(uuid);
            redirectAttributes.addFlashAttribute("mensagem", String.format("client ID - %s excluído com sucesso!", uuid));
        } catch (Exception e){
            redirectAttributes.addFlashAttribute("mensagem", e.getMessage());
        }

        return "redirect:/client";
    }

    @PostMapping("/client-add")
    public String addclient(ClientRequest client, BindingResult result,
                             Model model, RedirectAttributes redirectAttributes) {

        try{
            clientController.singUp(client);
            redirectAttributes.addFlashAttribute("mensagem", String.format("client %s cadastrado com sucesso!", client.getName()));
        } catch (Exception e){
            redirectAttributes.addFlashAttribute("mensagem", e.getMessage());
        }

        return "redirect:/client";
    }

    @PostMapping("/client-gravar/{id}")
    public String updateClientByUUID(@PathVariable("id") Integer id, Client client,
                                     BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        try{
            ClientRequest clientRequest = new ClientRequest();
            BeanUtils.copyProperties(client, clientRequest);
            clientController.updateByUUID(client.getUuid(), clientRequest);
            redirectAttributes.addFlashAttribute("mensagem", String.format("client %s atualizado com sucesso!", client.getName()));
        } catch (Exception e){
            redirectAttributes.addFlashAttribute("mensagem", e.getMessage());
        }
        return "redirect:/client";
    }

}
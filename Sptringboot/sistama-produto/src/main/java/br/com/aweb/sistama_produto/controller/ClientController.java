package br.com.aweb.sistama_produto.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.aweb.sistama_produto.model.Address;
import br.com.aweb.sistama_produto.model.Client;
import br.com.aweb.sistama_produto.service.ClientService;

@Controller
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService service;

    //listagem de clientes
    @GetMapping
    public String listClients(Model model) {
        model.addAttribute("clients", service.getAllClients());
        return "client/list";
    }

    //exibe o formulário de cadastro de cliente
    @GetMapping("/new")
    public String showClientForm(Model model) {
        Client client = new Client();
        client.setAddress(new Address());
        model.addAttribute("client", client);
        return "client/form";
    }

    //exibe o formulário para editar um cliente existente
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Client client = service.getClientById(id);
        if (client == null) {
            return "redirect:/clients";
        }
        model.addAttribute("client", client);
        return "client/form";
    }

    //salva um novo cliente
    @PostMapping("/save")
    public String saveClient(@Valid @ModelAttribute("client") Client client, BindingResult result) {
        validateUniqueness(client, result);
        if (result.hasErrors()) {
            return "client/form";
        }
        service.saveClient(client);
        return "redirect:/clients";
    }

    //atualiza um cliente existente
    @PostMapping("/update/{id}")
    public String updateClient(@PathVariable Long id,
                              @Valid @ModelAttribute("client") Client client,
                              BindingResult result) {
        validateUniqueness(client, result);
        if (result.hasErrors()) {
            return "client/form";
        }
        service.updateClient(id, client);
        return "redirect:/clients";
    }

    //remove um cliente
    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable Long id) {
        service.deleteClient(id);
        return "redirect:/clients";
    }

    private void validateUniqueness(Client client, BindingResult result) {
        if (client.getEmail() != null && service.emailInUse(client.getEmail(), client.getId())) {
            result.addError(new FieldError("client", "email", "E-mail already in use!🤬"));
        }
        if (client.getCpf() != null && service.cpfInUse(client.getCpf(), client.getId())) {
            result.addError(new FieldError("client", "cpf", "CPF already in use!🤬"));
        }
    }
}

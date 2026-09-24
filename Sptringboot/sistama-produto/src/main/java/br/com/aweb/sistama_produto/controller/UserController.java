package br.com.aweb.sistama_produto.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.aweb.sistama_produto.model.AppUser;
import br.com.aweb.sistama_produto.model.UserRole;
import br.com.aweb.sistama_produto.service.AppUserService;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private AppUserService service;

    //listagem de usuários (somente Administrador, restrito via SecurityConfig)
    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", service.getAllUsers());
        return "user/list";
    }

    //exibe o formulário de cadastro de usuário
    @GetMapping("/new")
    public String showUserForm(Model model) {
        model.addAttribute("user", new AppUser());
        model.addAttribute("roles", UserRole.values());
        return "user/form";
    }

    //cadastra um novo usuário
    @PostMapping("/save")
    public String saveUser(@Valid @ModelAttribute("user") AppUser user, BindingResult result, Model model,
                           RedirectAttributes redirectAttributes) {
        if (user.getUsername() != null && service.usernameInUse(user.getUsername())) {
            result.addError(new FieldError("user", "username", "Username already in use!🤬"));
        }
        if (result.hasErrors()) {
            model.addAttribute("roles", UserRole.values());
            return "user/form";
        }
        service.createUser(user);
        redirectAttributes.addFlashAttribute("successMessage", "Usuário cadastrado com sucesso!");
        return "redirect:/users";
    }
}

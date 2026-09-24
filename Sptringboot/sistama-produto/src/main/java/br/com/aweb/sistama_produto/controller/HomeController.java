package br.com.aweb.sistama_produto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "redirect:/products";
    }

    //exibe a tela de login (autenticação via Spring Security)
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}

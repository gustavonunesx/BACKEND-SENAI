package br.com.aweb.sistama_produto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.aweb.sistama_produto.service.ProductServce;
import ch.qos.logback.core.model.Model;


@Controller
@RequestMapping("/products")
public class ProductController {
    
    @Autowired
    private final ProductServce servcice;

    //listagem de produtos
    public String listProducts(Model model) {
        model.addAttribute("products", servcice.getAllProducts());
        return "product/list";
    }

    //retorna o nome da view do formulário de cadastro/edicao de produtos
    @RequestMapping("/new")
    public String showProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "product/form";
    }

}
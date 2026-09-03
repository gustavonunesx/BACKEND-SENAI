package br.com.aweb.sistama_produto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.aweb.sistama_produto.model.Product;
import br.com.aweb.sistama_produto.service.ProductServce;


@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductServce servcice;

    //listagem de produtos
    @GetMapping
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
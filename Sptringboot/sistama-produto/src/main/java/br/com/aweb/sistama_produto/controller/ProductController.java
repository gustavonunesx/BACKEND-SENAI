package br.com.aweb.sistama_produto.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.aweb.sistama_produto.model.Product;
import br.com.aweb.sistama_produto.service.ProductServce;


@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductServce service;

    //listagem de produtos
    @GetMapping
    public String listProducts(Model model) {
        model.addAttribute("products", service.getAllProducts());
        return "product/list";
    }

    //retorna o nome da view do formulário de cadastro/edicao de produtos
    @GetMapping("/new")
    public String showProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "product/form";
    }

    //exibe o formulário para editar um produto existente
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Product product = service.getProductById(id);
        if (product == null) {
            return "redirect:/products";
        }
        model.addAttribute("product", product);
        return "product/form";
    }

    //salva um novo produto
    @PostMapping("/save")
    public String saveProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "product/form";
        }
        service.saveProduct(product);
        return "redirect:/products";
    }

    //atualiza um produto existente
    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable Long id,
                               @Valid @ModelAttribute("product") Product product,
                               BindingResult result) {
        if (result.hasErrors()) {
            return "product/form";
        }
        service.updateProduct(id, product);
        return "redirect:/products";
    }

    //remove um produto
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        service.deleteProduct(id);
        return "redirect:/products";
    }

    //busca um produto por id
    @GetMapping("/{id}")
    public String getProductById(@PathVariable Long id, Model model) {
        Product product = service.getProductById(id);
        if (product == null) {
            return "redirect:/products";
        }
        model.addAttribute("product", product);
        return "product/details";
    }
}
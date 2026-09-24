package br.com.aweb.sistama_produto.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.aweb.sistama_produto.dto.OrderForm;
import br.com.aweb.sistama_produto.dto.OrderItemForm;
import br.com.aweb.sistama_produto.model.Order;
import br.com.aweb.sistama_produto.model.OrderItem;
import br.com.aweb.sistama_produto.model.OrderStatus;
import br.com.aweb.sistama_produto.service.ClientService;
import br.com.aweb.sistama_produto.service.OrderService;
import br.com.aweb.sistama_produto.service.OrderValidationException;
import br.com.aweb.sistama_produto.service.ProductServce;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private ProductServce productService;

    //listagem de pedidos
    @GetMapping
    public String listOrders(Model model) {
        model.addAttribute("orders", orderService.getAllOrders());
        return "order/list";
    }

    //exibe o formulário de registro de pedido
    @GetMapping("/new")
    public String showOrderForm(Model model) {
        OrderForm form = new OrderForm();
        form.getItems().add(new OrderItemForm());
        addFormAttributes(model, form);
        return "order/form";
    }

    //exibe o formulário para atualizar um pedido não finalizado
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Order order = orderService.getOrderById(id);
        if (order == null || order.getStatus() != OrderStatus.ATIVO) {
            return "redirect:/orders";
        }

        OrderForm form = new OrderForm();
        form.setId(order.getId());
        form.setClientId(order.getClient().getId());

        List<OrderItemForm> items = new ArrayList<>();
        for (OrderItem item : order.getItems()) {
            OrderItemForm itemForm = new OrderItemForm();
            itemForm.setProductId(item.getProduct().getId());
            itemForm.setQuantity(item.getQuantity());
            items.add(itemForm);
        }
        form.setItems(items);

        addFormAttributes(model, form);
        return "order/form";
    }

    //registra um novo pedido
    @PostMapping("/save")
    public String saveOrder(@ModelAttribute("orderForm") OrderForm form, Model model,
                            RedirectAttributes redirectAttributes) {
        try {
            orderService.createOrder(form);
            redirectAttributes.addFlashAttribute("successMessage", "Pedido registrado com sucesso!");
            return "redirect:/orders";
        } catch (OrderValidationException e) {
            model.addAttribute("errorMessage", e.getMessage());
            addFormAttributes(model, form);
            return "order/form";
        }
    }

    //atualiza um pedido não finalizado
    @PostMapping("/update/{id}")
    public String updateOrder(@PathVariable Long id, @ModelAttribute("orderForm") OrderForm form, Model model,
                              RedirectAttributes redirectAttributes) {
        try {
            orderService.updateOrder(id, form);
            redirectAttributes.addFlashAttribute("successMessage", "Pedido atualizado com sucesso!");
            return "redirect:/orders";
        } catch (OrderValidationException e) {
            model.addAttribute("errorMessage", e.getMessage());
            addFormAttributes(model, form);
            return "order/form";
        }
    }

    //cancela um pedido (devolve estoque, não exclui o registro)
    @GetMapping("/cancel/{id}")
    public String cancelOrder(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        orderService.cancelOrder(id);
        redirectAttributes.addFlashAttribute("successMessage", "Pedido cancelado e estoque devolvido.");
        return "redirect:/orders";
    }

    private void addFormAttributes(Model model, OrderForm form) {
        model.addAttribute("orderForm", form);
        model.addAttribute("clients", clientService.getAllClients());
        model.addAttribute("products", productService.getAllProducts());
    }
}

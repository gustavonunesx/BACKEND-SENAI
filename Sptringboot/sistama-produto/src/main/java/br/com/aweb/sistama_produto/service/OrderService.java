package br.com.aweb.sistama_produto.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.aweb.sistama_produto.dto.OrderForm;
import br.com.aweb.sistama_produto.dto.OrderItemForm;
import br.com.aweb.sistama_produto.model.Client;
import br.com.aweb.sistama_produto.model.Order;
import br.com.aweb.sistama_produto.model.OrderItem;
import br.com.aweb.sistama_produto.model.OrderStatus;
import br.com.aweb.sistama_produto.model.Product;
import br.com.aweb.sistama_produto.repository.ClientRepository;
import br.com.aweb.sistama_produto.repository.OrderRepository;
import br.com.aweb.sistama_produto.repository.ProductRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Transactional
    public Order createOrder(OrderForm form) {
        Client client = findClient(form.getClientId());

        Order order = new Order();
        order.setClient(client);
        order.setOrderDate(LocalDateTime.now());
        order.setStatus(OrderStatus.ATIVO);

        applyItems(order, form.getItems());

        return orderRepository.save(order);
    }

    @Transactional
    public Order updateOrder(Long id, OrderForm form) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderValidationException("Order not found!🤬"));

        if (order.getStatus() != OrderStatus.ATIVO) {
            throw new OrderValidationException("Cannot update a cancelled order!🤬");
        }

        Client client = findClient(form.getClientId());
        order.setClient(client);

        // devolve ao estoque as quantidades atuais antes de reaplicar os novos itens
        for (OrderItem item : order.getItems()) {
            Product product = item.getProduct();
            product.setQuantity(product.getQuantity() + item.getQuantity());
            productRepository.save(product);
        }
        order.getItems().clear();

        applyItems(order, form.getItems());

        return orderRepository.save(order);
    }

    @Transactional
    public void cancelOrder(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderValidationException("Order not found!🤬"));

        if (order.getStatus() == OrderStatus.CANCELADO) {
            return;
        }

        for (OrderItem item : order.getItems()) {
            Product product = item.getProduct();
            product.setQuantity(product.getQuantity() + item.getQuantity());
            productRepository.save(product);
        }

        order.setStatus(OrderStatus.CANCELADO);
        orderRepository.save(order);
    }

    private Client findClient(Long clientId) {
        if (clientId == null) {
            throw new OrderValidationException("Client is mandatory!🤬");
        }
        return clientRepository.findById(clientId)
                .orElseThrow(() -> new OrderValidationException("Client not found!🤬"));
    }

    private void applyItems(Order order, List<OrderItemForm> itemForms) {
        double total = 0.0;

        if (itemForms != null) {
            for (OrderItemForm itemForm : itemForms) {
                if (itemForm.getProductId() == null || itemForm.getQuantity() == null) {
                    continue;
                }
                if (itemForm.getQuantity() <= 0) {
                    throw new OrderValidationException("Product quantity must be greater than zero!🤬");
                }

                Product product = productRepository.findById(itemForm.getProductId())
                        .orElseThrow(() -> new OrderValidationException("Product not found!🤬"));

                if (product.getQuantity() < itemForm.getQuantity()) {
                    throw new OrderValidationException(
                            "Insufficient stock for product '" + product.getName() + "'!🤬");
                }

                OrderItem item = new OrderItem();
                item.setOrder(order);
                item.setProduct(product);
                item.setQuantity(itemForm.getQuantity());
                item.setUnitPrice(product.getPrice());
                order.getItems().add(item);

                product.setQuantity(product.getQuantity() - itemForm.getQuantity());
                productRepository.save(product);

                total += product.getPrice() * itemForm.getQuantity();
            }
        }

        if (order.getItems().isEmpty()) {
            throw new OrderValidationException("Order must have at least one product!🤬");
        }

        order.setTotalValue(total);
    }
}

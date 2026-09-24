package br.com.aweb.sistama_produto.dto;

import java.util.ArrayList;
import java.util.List;

public class OrderForm {

    private Long id;

    private Long clientId;

    private List<OrderItemForm> items = new ArrayList<>();

    public OrderForm() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public List<OrderItemForm> getItems() {
        return items;
    }

    public void setItems(List<OrderItemForm> items) {
        this.items = items;
    }
}

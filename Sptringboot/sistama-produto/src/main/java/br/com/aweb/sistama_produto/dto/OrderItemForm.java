package br.com.aweb.sistama_produto.dto;

public class OrderItemForm {

    private Long productId;

    private Integer quantity;

    public OrderItemForm() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}

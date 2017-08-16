package edu.mum.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Table(name="Orderline")
public class OrderLine {

    @Id @GeneratedValue
    private int orderLineId;
    @Min(value=0)
    private int quantity;
    @OneToOne
    private Product product;
    @ManyToOne
    private Order order;

    public OrderLine() {
    }

    public OrderLine(int quantity, Product product, Order order) {
        this.quantity = quantity;
        this.product = product;
        this.order = order;
    }

    public int getOrderLineId() {
        return orderLineId;
    }

    public void setOrderLineId(int orderLineId) {
        this.orderLineId = orderLineId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}

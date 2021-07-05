package com.tybootcamp.ecomm.entities;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class BasketProduct {
    @EmbeddedId
    private long id;

    @NotNull
    private Product product;

    @NotNull
    private int quantity;

    public BasketProduct() {

    }

    public BasketProduct(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    @Transient
    public float getTotalPrice() {
        return getProduct().getPrice() * getQuantity();
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

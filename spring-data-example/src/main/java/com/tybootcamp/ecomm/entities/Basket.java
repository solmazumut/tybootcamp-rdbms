package com.tybootcamp.ecomm.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "basket")
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @OneToMany(mappedBy = "BasketProduct")
    @ElementCollection
    @CollectionTable(name = "Products_In_Basket", joinColumns = @JoinColumn(name = "product_id", nullable = false))
    @Column(name = "products")
    private List<BasketProduct> products;

    private List<Integer> numberOfProduct;

    @Transient
    public Double getTotalBasketPrice() {
        double sum = 0D;
        List<BasketProduct> basketProducts = getProducts();
        for (BasketProduct op : basketProducts) {
            sum += op.getTotalPrice();
        }
        return sum;
    }

    public List<BasketProduct> getProducts() {
        return products;
    }

    public List<Integer> getNumberOfProduct() {
        return numberOfProduct;
    }
}

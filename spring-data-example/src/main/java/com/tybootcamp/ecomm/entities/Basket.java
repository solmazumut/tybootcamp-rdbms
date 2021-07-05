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


    @ElementCollection
    @CollectionTable(name = "Products", joinColumns = @JoinColumn(name = "product_id", nullable = false))
    @Column(name = "products")
    private List<String> products;

}

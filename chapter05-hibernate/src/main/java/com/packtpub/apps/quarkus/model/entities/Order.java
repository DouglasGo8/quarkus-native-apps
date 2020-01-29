package com.packtpub.apps.quarkus.model.entities;

import lombok.Data;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;

@Data
@Entity
@Table(name = "TBL_ORDER")
@NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Order o WHERE o.customer.id = :customerId ORDER BY o.item")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String item;

    private double price;

    @ManyToOne
    @JsonbTransient
    @JoinColumn(name = "customer_id")
    public Customer customer;
}

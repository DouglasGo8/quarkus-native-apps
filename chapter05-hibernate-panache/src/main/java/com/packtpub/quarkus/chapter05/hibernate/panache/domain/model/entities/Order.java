package com.packtpub.quarkus.chapter05.hibernate.panache.domain.model.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Order extends PanacheEntity {
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

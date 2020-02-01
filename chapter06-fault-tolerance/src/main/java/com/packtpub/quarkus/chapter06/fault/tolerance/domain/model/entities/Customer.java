package com.packtpub.quarkus.chapter06.fault.tolerance.domain.model.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Cacheable
@NamedQuery(name = "Customers.findAll", query = "SELECT c FROM Customer c ORDER BY c.id",
        hints = @QueryHint(name = "org.hibernate.cacheable", value = "true") )
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;


}

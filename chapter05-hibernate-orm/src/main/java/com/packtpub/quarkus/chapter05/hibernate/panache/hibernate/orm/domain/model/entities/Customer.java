package com.packtpub.quarkus.chapter05.hibernate.panache.hibernate.orm.domain.model.entities;


import lombok.Data;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "TBL_CUSTOMER")
@NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c ORDER BY c.id",
        hints = @QueryHint(name = "org.hibernate.cacheable", value = "true"))
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    @JsonbTransient
    @OneToMany(mappedBy = "customer")
    public List<Order> orders;

}

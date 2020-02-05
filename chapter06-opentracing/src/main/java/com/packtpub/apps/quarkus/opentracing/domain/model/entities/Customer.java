package com.packtpub.apps.quarkus.opentracing.domain.model.entities;


import lombok.Data;

import javax.persistence.*;

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

}

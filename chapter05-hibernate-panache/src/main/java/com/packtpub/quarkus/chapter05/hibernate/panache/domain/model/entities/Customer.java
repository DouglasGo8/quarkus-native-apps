package com.packtpub.quarkus.chapter05.hibernate.panache.domain.model.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Cacheable
@EqualsAndHashCode(callSuper = true)
public class Customer extends PanacheEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    @JsonbTransient
    @OneToMany(mappedBy = "customer")
    public List<Order> orders;

}

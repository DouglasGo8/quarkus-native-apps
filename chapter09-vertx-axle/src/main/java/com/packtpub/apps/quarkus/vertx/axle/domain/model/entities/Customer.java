package com.packtpub.apps.quarkus.vertx.axle.domain.model.entities;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {

    private Integer id;
    private String name;
    private String surname;

    @Override
    public String toString() {
        return name + " " + surname;
    }

}

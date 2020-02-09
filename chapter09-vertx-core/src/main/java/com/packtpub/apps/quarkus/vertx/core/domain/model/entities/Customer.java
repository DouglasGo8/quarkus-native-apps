package com.packtpub.apps.quarkus.vertx.core.domain.model.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Customer {

    private Integer id;
    private String name;
    private String surname;

    @java.lang.Override
    public java.lang.String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}

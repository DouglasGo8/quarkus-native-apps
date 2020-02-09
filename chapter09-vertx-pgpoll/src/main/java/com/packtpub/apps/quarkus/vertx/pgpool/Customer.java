package com.packtpub.apps.quarkus.vertx.pgpool;

import io.vertx.axle.pgclient.PgPool;
import io.vertx.axle.sqlclient.Row;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletionStage;


@Getter
@NoArgsConstructor
@ApplicationScoped
public class Customer {

    private Long id;
    private String name;
    private String surname;

    public Customer (Long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    @Inject
    private PgPool client;

    @Override
    public String toString() {
        return id + "," + name + "," + surname;
    }

    public CompletionStage<List<Customer>> findAll() {
        return client.query("SELECT id, name, surname FROM TBL_CUSTOMER ORDER BY name ASC")
                .thenApply(pgRowSet -> {

                    final List<Customer> list = new ArrayList<>(pgRowSet.size());

                    pgRowSet.forEach(row -> list.add(from(row)));

                    return list;
                });
    }

    private static Customer from(Row row) {
        return new Customer(row.getLong("id"), row.getString("name"), row.getString("surname"));
    }
}

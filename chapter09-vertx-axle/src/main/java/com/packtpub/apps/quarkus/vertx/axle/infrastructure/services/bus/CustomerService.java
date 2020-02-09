package com.packtpub.apps.quarkus.vertx.axle.infrastructure.services.bus;

import com.packtpub.apps.quarkus.vertx.axle.domain.model.entities.Customer;
import io.quarkus.vertx.ConsumeEvent;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CustomerService {


    @ConsumeEvent("vm-customer")
    public String reply(Customer c) {
        return "Hello! I am " + c.getName() + " " +c.getSurname() + ". How are you doing?";
    }
}

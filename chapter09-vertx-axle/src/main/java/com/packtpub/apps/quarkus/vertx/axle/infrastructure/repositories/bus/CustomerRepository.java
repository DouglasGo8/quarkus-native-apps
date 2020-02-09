package com.packtpub.apps.quarkus.vertx.axle.infrastructure.repositories.bus;

import com.packtpub.apps.quarkus.vertx.axle.domain.model.entities.Customer;
import io.vertx.core.eventbus.DeliveryOptions;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CustomerRepository {

    public Customer findCustomerById(Integer custId) {
        return new Customer(custId, "douglas", "batista");
    }
}

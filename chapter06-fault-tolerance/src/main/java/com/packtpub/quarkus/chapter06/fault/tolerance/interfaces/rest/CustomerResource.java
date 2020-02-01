package com.packtpub.quarkus.chapter06.fault.tolerance.interfaces.rest;


import com.packtpub.quarkus.chapter06.fault.tolerance.domain.model.entities.Customer;
import com.packtpub.quarkus.chapter06.fault.tolerance.infrastructure.repositories.hibernate.CustomerRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("customers")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class CustomerResource {

    @Inject
    private CustomerRepository customerRepository;

    @GET
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

}
package com.packtpub.quarkus.chapter05.hibernate.panache.hibernate.orm.interfaces.rest;

import com.packtpub.quarkus.chapter05.hibernate.panache.hibernate.orm.infrastructure.repositories.hibernate.CustomerRepository;
import com.packtpub.quarkus.chapter05.hibernate.panache.hibernate.orm.domain.model.entities.Customer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/customer")
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
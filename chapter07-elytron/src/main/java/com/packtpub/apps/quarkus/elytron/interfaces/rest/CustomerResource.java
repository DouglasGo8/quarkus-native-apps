package com.packtpub.apps.quarkus.elytron.interfaces.rest;


import com.packtpub.apps.quarkus.elytron.domain.model.entities.Customer;
import com.packtpub.apps.quarkus.elytron.infrastructure.repositories.hibernate.CustomerRepository;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/customer")
@ApplicationScoped
@RolesAllowed("user")
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
package com.packtpub.apps.quarkus.keycloak.interfaces.rest;


import com.packtpub.apps.quarkus.keycloak.domain.model.entities.Customer;
import com.packtpub.apps.quarkus.keycloak.infrastructure.repositories.hibernate.CustomerRepository;
import io.quarkus.security.identity.SecurityIdentity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.Iterator;
import java.util.List;

@Path("/customer")
@ApplicationScoped
@RolesAllowed("user")
@Produces("application/json")
@Consumes("application/json")
public class CustomerResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerResource.class.getName());

    @Inject
    private CustomerRepository customerRepository;
    @Inject
    private SecurityIdentity securityContext;

    @GET
    @RolesAllowed("user")
    public List<Customer> getAll() {

        LOGGER.info("Connected with User " + securityContext.getPrincipal().getName());

        securityContext.getRoles().forEach((s) -> LOGGER.info("Role: " + s));

        return customerRepository.findAll();
    }

}
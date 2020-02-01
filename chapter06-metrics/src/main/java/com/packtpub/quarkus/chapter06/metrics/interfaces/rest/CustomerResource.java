package com.packtpub.quarkus.chapter06.metrics.interfaces.rest;


import com.packtpub.quarkus.chapter06.metrics.domain.model.entities.Customer;
import com.packtpub.quarkus.chapter06.metrics.infrastructure.repositories.hibernate.CustomerRepository;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;

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
    @Counted(description = "Customer list count", absolute = true)
    @Timed(name="timerCheck", description = "How much time it takes to load the Customer list", unit = MetricUnits.MILLISECONDS)
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

}
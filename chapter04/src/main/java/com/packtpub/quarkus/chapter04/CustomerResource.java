package com.packtpub.quarkus.chapter04;

import com.packtpub.quarkus.chapter04.model.Customer;
import com.packtpub.quarkus.chapter04.repo.CustomerRepo;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/customers")
@ApplicationScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResource {

    @Inject
    private CustomerRepo repo;

    @GET
    public List<Customer> getAll() {
        return this.repo.findAll();
    }

    @POST
    public Response create(Customer customer) {
        this.repo.createCustomer(customer);
        return Response.status(201).build();
    }

    @PUT
    public Response update(Customer customer) {
        this.repo.updateCustomer(customer);
        return Response.status(204).build();

    }

    @DELETE
    public Response delete(@QueryParam("id") Integer customerId) {
        this.repo.deleteCustomer(customerId);
        return Response.status(204).build();
    }

}
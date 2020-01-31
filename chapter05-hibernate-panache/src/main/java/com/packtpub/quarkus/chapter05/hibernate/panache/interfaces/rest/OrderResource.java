package com.packtpub.quarkus.chapter05.hibernate.panache.interfaces.rest;

import com.packtpub.quarkus.chapter05.hibernate.panache.domain.model.entities.Customer;
import com.packtpub.quarkus.chapter05.hibernate.panache.domain.model.entities.Order;
import com.packtpub.quarkus.chapter05.hibernate.panache.infrastructure.repositories.hibernate.CustomerRepository;
import com.packtpub.quarkus.chapter05.hibernate.panache.infrastructure.repositories.hibernate.OrderRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("orders")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class OrderResource {

    @Inject
    private OrderRepository orderRepository;
    @Inject
    private CustomerRepository customerRepository;

    @GET
    public List<Order> getAll(@QueryParam("customerId") Long customerId) {
        return orderRepository.findAll(customerId);
    }

    @POST
    @Path("/{customer}")
    public Response create(Order order, @PathParam("customer") Long customerId) {

        Customer c = customerRepository.findCustomerById(customerId);

        orderRepository.createOrder(order, c);
        return Response.status(201).build();

    }

    @PUT
    public Response update(Order order) {
        orderRepository.updateOrder(order);
        return Response.status(204).build();
    }

    @DELETE
    @Path("/{order}")
    public Response delete(@PathParam("order") Long orderId) {
        orderRepository.deleteOrder(orderId);
        return Response.status(204).build();
    }

}
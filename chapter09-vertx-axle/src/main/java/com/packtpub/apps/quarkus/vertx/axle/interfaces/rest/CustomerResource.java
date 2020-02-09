package com.packtpub.apps.quarkus.vertx.axle.interfaces.rest;


import com.packtpub.apps.quarkus.vertx.axle.infrastructure.repositories.bus.CustomerRepository;
import io.vertx.axle.core.eventbus.EventBus;
import io.vertx.axle.core.eventbus.Message;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.concurrent.CompletionStage;

@Path("customers")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class CustomerResource {

    @Inject
    private EventBus bus;

    @Inject
    private CustomerRepository repository;

    @GET
    @Path("/call")
    @Produces("text/plain")
    public CompletionStage<String> call(@QueryParam("id") Integer custId) {
        return this.bus.<String>send("vm-customer", this.repository.findCustomerById(custId))
                .thenApply(Message::body)
                .exceptionally(Throwable::getMessage);
    }

}

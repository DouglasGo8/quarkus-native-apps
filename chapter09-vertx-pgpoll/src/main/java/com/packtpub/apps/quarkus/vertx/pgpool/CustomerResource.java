package com.packtpub.apps.quarkus.vertx.pgpool;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import java.util.concurrent.CompletionStage;

@Path("/customers")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerResource {

    @Inject
    private Customer customer;

    @GET
    public CompletionStage<Response> getAll() {
        return customer.findAll().thenApply(Response::ok)
                .thenApply(ResponseBuilder::build);
    }
}

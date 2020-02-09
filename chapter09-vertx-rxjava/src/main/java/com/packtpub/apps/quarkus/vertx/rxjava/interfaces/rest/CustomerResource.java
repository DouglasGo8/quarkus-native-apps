package com.packtpub.apps.quarkus.vertx.rxjava.interfaces.rest;


import com.packtpub.apps.quarkus.vertx.rxjava.infrastructure.repositories.file.CustomerRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.concurrent.CompletionStage;


@Path("/customers")
@ApplicationScoped
@Consumes("application/json")
@Produces("application/json")
public class CustomerResource {


    @Inject
    private CustomerRepository repository;

    @GET
    @Path("writefile")
    @Produces("text/plain")
    public CompletionStage<String> writeFile() {
        return this.repository.writeFile();
    }

    @GET
    @Path("readfile")
    @Produces("text/plain")
    public CompletionStage<String> readFile() {
        return this.repository.readFile();
    }
}

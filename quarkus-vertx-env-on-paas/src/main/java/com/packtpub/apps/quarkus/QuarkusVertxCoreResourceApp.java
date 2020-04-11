package com.packtpub.apps.quarkus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;


@Path("/env/info")
@ApplicationScoped
@Produces("text/plain")
public class QuarkusVertxCoreResourceApp {

    private static final Logger LOGGER = LoggerFactory.getLogger(QuarkusVertxCoreResourceApp.class);

    @GET
    public CompletionStage<String> sayHi() {

        // LOGGER.info("");

        return CompletableFuture.supplyAsync(() -> "Say Hi");
    }


}
package com.packtpub.apps.quarkus.scheduler.interfaces.rest;


import com.packtpub.apps.quarkus.scheduler.infrastructure.servies.sheduler.TokenGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/token")
public class CustomerResource {


    protected final Logger log = LoggerFactory.getLogger(CustomerResource.class);

    @Inject
    private TokenGenerator token;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getToken() {
        return token.getToken();
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public String oneTimeEvent() {
        return "started!";
    }

    public void event() {
        log.info("Called One Time Event!");
    }


}

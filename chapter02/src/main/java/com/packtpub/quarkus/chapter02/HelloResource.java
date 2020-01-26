package com.packtpub.quarkus.chapter02;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.time.LocalDateTime;

@Path("/hello")
public class HelloResource {

    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {

        return String.format("hello at %s", LocalDateTime.now());
    }

    @GET
    @Path("{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@PathParam("name") String name) {
        log.info(name + " called");
        return String.format("hello %s at %s", name, LocalDateTime.now());
    }
}
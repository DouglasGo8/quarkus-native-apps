package com.packtpub.quarkus.chapter03;


import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/container")
public class HelloResource {


    @Inject
    private ContainerService containerService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return String.format("You're running on %s", containerService.ofContainerId());
    }

}

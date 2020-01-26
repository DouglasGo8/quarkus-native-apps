package com.manning.k8s.in.action;

import com.manning.k8s.in.action.model.Person;
import org.apache.camel.ProducerTemplate;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/app")
public class QuarkusApp {


    @Inject
    private ProducerTemplate producer;

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person sayHello(@PathParam("name") String name) {
        return producer.requestBody("direct:quarkus", name, Person.class);
    }
}
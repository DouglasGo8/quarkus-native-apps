package com.packtpub.apps.quarkus.vertx.axle.interfaces.rest;

import io.vertx.axle.core.Vertx;
import org.eclipse.microprofile.reactive.streams.operators.ReactiveStreams;
import org.reactivestreams.Publisher;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;

@Path("/streaming")
public class StreamingEndpoint {

    @Inject
    private Vertx vertx;

    @GET
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public Publisher<String> stream() {
        return ReactiveStreams.fromPublisher(this.vertx.periodicStream(2000).toPublisher())
                .map(v -> String.format("Time %s", LocalDate.now().toString()))
                .buildRs();
    }
}

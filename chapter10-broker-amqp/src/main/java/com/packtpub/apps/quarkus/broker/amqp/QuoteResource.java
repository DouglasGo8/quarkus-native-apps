package com.packtpub.apps.quarkus.broker.amqp;

import io.smallrye.reactive.messaging.annotations.Channel;
import org.jboss.resteasy.annotations.SseElementType;
import org.reactivestreams.Publisher;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/quotes")
public class QuoteResource {

    @Inject
    @Channel("inMemoryStreamTopic")
    private Publisher<String> quote;

    @GET
    @Path("/stream")
    @SseElementType("text/plain")
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public Publisher<String> stream() {
        return this.quote;
    }
}

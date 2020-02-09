package com.packtpub.apps.quarkus.broker.amqp;

import io.reactivex.Flowable;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@ApplicationScoped
public class QuoteGenerator {

    private final Random random = new Random();

    @Outgoing("stocksTopic")
    public Flowable<String> generate() {
        return Flowable.interval(2, TimeUnit.SECONDS)
                .map(tick -> generateQuote(random.nextInt(2),
                        random.nextInt(5), random.nextInt(100)));
    }

    private String generateQuote(int type, int company, int amount) {
        Jsonb jsonb = JsonbBuilder.create();
        Operation operation = new Operation(type, Company.values()[company], amount);
        return jsonb.toJson(operation);

    }
}

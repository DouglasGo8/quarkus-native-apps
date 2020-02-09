package com.packtpub.apps.quarkus.broker.amqp;

import io.smallrye.reactive.messaging.annotations.Broadcast;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.util.HashMap;
import java.util.Random;

@NoArgsConstructor
@ApplicationScoped
public class QuoteConverter {

    private final Random random = new Random();
    private HashMap<String, Double> quotes;

    @PostConstruct
    public void init() {
        this.quotes = new HashMap<>();
        for (Company company: Company.values())
            quotes.put(company.name(), (double) (random.nextInt(100) + 50));
    }

    @Broadcast
    @Incoming("stocksTopic")
    @Outgoing("inMemoryStreamTopic")
    public String newQuote(String quoteJson) {

        Jsonb jsonb = JsonbBuilder.create();
        Operation operation = jsonb.fromJson(quoteJson, Operation.class);
        double currentQuote = quotes.get(operation.getCompany().name());
        double newQuote;
        double change = (operation.getAmount() / 25);
        if (operation.getType() == Operation.BUY) {
            newQuote = currentQuote + change;
        }
        else  {
            newQuote = currentQuote - change;
        }
        if (newQuote < 0) newQuote = 0;
        quotes.replace(operation.getCompany().name(), newQuote);
        Quote quote = new Quote(newQuote, operation.getCompany().name());
        return jsonb.toJson(quote);
    }
}

package com.packtpub.apps.quarkus.vertx.core.infrastructure.repositories.file;

import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.NANOSECONDS;

@ApplicationScoped
public class CustomerRepository {

    @Inject
    private Vertx vertx;

    @ConfigProperty(name = "file.path")
    private String path;

    public CompletionStage<String> writeFile() {


        final JsonArrayBuilder jsonArray = Json.createArrayBuilder();
        final CompletableFuture<String> future = new CompletableFuture<>();

        final JsonArray array = jsonArray.add(Json.createObjectBuilder().add("id", 1)
                .add("name", "douglas")
                .add("surname", "batista").build()).build();

        this.vertx.fileSystem().writeFile(path, Buffer.buffer(array.toString()), hnD -> {
            if (hnD.succeeded()) {
                future.complete("Written JSON file in " + path);
            } else {
                future.complete("Error while writing in file: " + hnD.cause().getMessage());
            }
        });

        return future;

    }

    public CompletionStage<String> readFile() {

        final long start = System.nanoTime();
        final CompletableFuture<String> future = new CompletableFuture<>();

        vertx.setTimer(100, cb -> {

            final long duration = MILLISECONDS.convert(System.nanoTime() - start, NANOSECONDS);
            this.vertx.fileSystem().readFile(path, hnD -> {
                if (hnD.succeeded()) {
                    String response = hnD.result().toString("UTF-8");
                    future.complete(response);
                } else {
                    future.complete("Cannot read the file: " + hnD.cause().getMessage());
                }
            });
        });

        return future;
    }
}

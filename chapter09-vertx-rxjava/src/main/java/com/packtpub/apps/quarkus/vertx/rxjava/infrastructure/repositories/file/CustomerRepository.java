package com.packtpub.apps.quarkus.vertx.rxjava.infrastructure.repositories.file;


import com.packtpub.apps.quarkus.vertx.rxjava.domain.model.entities.Customer;
import com.sun.tools.javac.util.List;
import io.reactivex.Observable;
import io.vertx.reactivex.core.Vertx;
import io.vertx.reactivex.core.buffer.Buffer;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@ApplicationScoped
public class CustomerRepository {

    @Inject
    private Vertx vertx;

    @ConfigProperty(name = "file.path")
    private String path;

    public CompletionStage<String> writeFile() {

        CompletableFuture<String> future = new CompletableFuture<>();
        StringBuffer sb = new StringBuffer("id,name,surname");
        sb.append("\n");

        Observable.fromIterable(List.of(new Customer(1, "douglas", "batista")))
                .map(c -> c.getId() + "," + c.getName() + "," + c.getSurname() + "\n")
                .subscribe(
                        sb::append,
                        System.err::println,
                        () -> vertx.fileSystem().writeFile(path, Buffer.buffer(sb.toString()), handler -> {
                            if (handler.succeeded()) {
                                future.complete("File written in " + path);
                            } else {
                                System.err.println("Error while writing in file: " + handler.cause().getMessage());

                            }
                        }));

        return future;


    }

    public CompletionStage<String> readFile() {

        final CompletableFuture<String> future = new CompletableFuture<>();
        final StringBuffer sb = new StringBuffer("id,name,surname");
        sb.append('\n');

        this.vertx.fileSystem().rxReadFile(path)
                .flatMapObservable(buffer -> Observable.fromArray(buffer.toString().split("\n")))
                .skip(1)
                .map(s -> s.split(","))
                .map(data -> new Customer(Integer.parseInt(data[0]), data[1], data[2]))
                .subscribe(data -> sb.append(data.toString()), System.err::println,
                        () -> future.complete(sb.toString()));

        return future;
    }
}

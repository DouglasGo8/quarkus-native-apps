package com.packtpub.quarkus.chapter06.health.check.infrastructure.health;


import lombok.SneakyThrows;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.HealthCheckResponseBuilder;
import org.eclipse.microprofile.health.Liveness;

import javax.enterprise.context.ApplicationScoped;
import java.net.Socket;


@Liveness
@ApplicationScoped
public class DBHealthCheck implements HealthCheck {

    @ConfigProperty(name = "db.host")
    private String host;
    @ConfigProperty(name = "db.port")
    private Integer port;

    @Override
    public HealthCheckResponse call() {

        final HealthCheckResponseBuilder responseBuilder = HealthCheckResponse.named("Db Health check Connection");

        try {
            serverListening(this.host, this.port);
        } catch (Exception e) {
            responseBuilder.down().withData("error", e.getMessage());
        }
        return responseBuilder.build();
    }

    @SneakyThrows
    private void serverListening(String host, int port) {
        final Socket s = new Socket(host, port);
        s.close();
    }
}

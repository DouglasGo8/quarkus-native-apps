package com.packtpub.apps.quarkus.scheduler.infrastructure.servies.sheduler;

import io.quarkus.scheduler.Scheduled;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
public class TokenGenerator {

    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    @Getter
    private String token;

    @Scheduled(cron = "* * * * * ?")
    public void generateToken() {
        this.token = UUID.randomUUID().toString();
        log.info("Token generated");
    }

}

package com.packtpub.quarkus.chapter03;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ContainerService {
    public String ofContainerId() {
        return System.getenv().getOrDefault("HOSTNAME", "unknown");
    }
}

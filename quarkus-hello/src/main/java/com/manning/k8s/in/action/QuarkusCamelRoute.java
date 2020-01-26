package com.manning.k8s.in.action;

import org.apache.camel.builder.RouteBuilder;


public class QuarkusCamelRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("direct:quarkus")
                .bean(QuarkusCamelBean::new)
                .log("${body}")
                .end();

    }


}

package com.manning.k8s.in.action;


import com.manning.k8s.in.action.model.Person;
import lombok.SneakyThrows;

import java.net.InetAddress;

public class QuarkusCamelBean {

    @SneakyThrows
    public Person sayHello(String name) {
        return new Person(name, InetAddress.getLocalHost().getHostName());
    }

}

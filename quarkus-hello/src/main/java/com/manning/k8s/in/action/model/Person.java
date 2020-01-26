package com.manning.k8s.in.action.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {

    private final String name;
    private final String hostName;

}

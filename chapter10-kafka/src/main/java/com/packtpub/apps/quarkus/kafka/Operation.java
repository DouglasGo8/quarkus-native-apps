package com.packtpub.apps.quarkus.kafka;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@RegisterForReflection
public class Operation {

    public static final int SELL = 0;
    public static final int BUY = 1;
    private int amount;
    private Company company;
    private int type;

    public Operation(int type, Company company, int amount) {
        this.amount = amount;
        this.company = company;
        this.type = type;
    }

    public Operation(int type, int amount) {
        this.amount = amount;
        this.company = Company.Initech;
        this.type = type;
    }

}

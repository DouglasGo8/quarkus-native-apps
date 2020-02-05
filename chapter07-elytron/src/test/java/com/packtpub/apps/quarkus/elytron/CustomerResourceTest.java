package com.packtpub.apps.quarkus.elytron;


import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class CustomerResourceTest {


    @Test
    public void testCustomerService() {

        given().auth()

                .preemptive()
                .basic("frank", "password123")
                .when().get("/customers")
                .then()
                .statusCode(200)
                .body("$.size()", is(2));
    }
}

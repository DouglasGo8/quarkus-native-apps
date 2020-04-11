package com.packtpub.quarkus.chapter04;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.json.Json;
import javax.json.JsonObject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ExampleResourceTest {

    @Test
    public void testCustomerResource() {

        JsonObject json = Json.createObjectBuilder()
                .add("name", "John")
                .add("surname", "Smith")
                .build();

        given().contentType("application/json")
                .body(json.toString())
                .when()
                .post("/customers")
                .then()
                .statusCode(201);

        given().when()
                .get("/customers")
                .then()
                .statusCode(200)
                .body(containsString("John"), containsString("Smith"));

        json = Json.createObjectBuilder()
                .add("id", "0")
                .add("name", "Duck")
                .add("surname", "Donald")
                .build();

        given()
                .contentType("application/json")
                .body(json.toString())
                .put("/customers")
                .then()
                .statusCode(204);

        given()
                .contentType("application/json")
                .when()
                .delete("/customers?id=0")
                .then()
                .statusCode(204);



    }

}
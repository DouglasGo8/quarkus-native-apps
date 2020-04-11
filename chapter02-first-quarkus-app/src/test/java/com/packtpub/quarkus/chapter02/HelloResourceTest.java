package com.packtpub.quarkus.chapter02;

import io.quarkus.test.junit.QuarkusTest;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;


@QuarkusTest
public class HelloResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(containsString("hello"));
    }

    @Test
    @Ignore
    public void testHelloEndpointHeader() {
        given()
          .when().get("hello")
          .then()
          .statusCode(200)
          .body(containsString("hello"))
          .and().header("Content-Length", "6");
    }

    @Test
    @Ignore
    public void testHelloEndpointPathParam() {
        given()
          .pathParam("name", "Frank")
          .when().get("/hello/{name}")
          .then().statusCode(200)
          .body(containsString("Frank"));
    }

}
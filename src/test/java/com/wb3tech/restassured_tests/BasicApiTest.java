package com.wb3tech.restassured_tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

public class BasicApiTest {

    @Test
    public void getStatusCodeIs200() {
        RestAssured.get("https://api.github.com")
                .then()
                .statusCode(200);
    }
}

package com.wb3tech.java_httpclient_tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetHeader_Tests {

    private final static String BASE_URL = "https://api.github.com/";

    static HttpClient httpClient = HttpClient.newBuilder().build();
    static HttpResponse<Void> response;

    @BeforeAll
    static void setup() throws IOException, InterruptedException {
        // Arrange
        var request = HttpRequest.newBuilder(URI.create(BASE_URL))
                .setHeader("User-Agent", "WB3Tech Bot")
                .build();
        // Act
        response = httpClient.send(request, HttpResponse.BodyHandlers.discarding());

    }

    @ParameterizedTest
    @CsvSource({
            "x-Ratelimit-Limit,60",
            "content-type,application/json; charset=utf-8",
            "server,GitHub.com",
            "x-frame-options,deny"
    })
    void parameterizedTestForHeaders(String header, String expectedValue) throws IOException, InterruptedException {
        var actualValue = response.headers().firstValue(header).get();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    void getReturn200() throws IOException, InterruptedException {
        var actualStatusCode = response.statusCode();
        assertEquals(200, actualStatusCode);
    }

}

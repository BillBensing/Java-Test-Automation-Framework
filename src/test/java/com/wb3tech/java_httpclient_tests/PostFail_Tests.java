package com.wb3tech.java_httpclient_tests;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostFail_Tests {

    private final static String BASE_URL = "https://api.github.com/";

    static HttpClient httpClient = HttpClient.newBuilder().build();

    @Test
    void postWithoutAuthorizationFails() throws IOException, InterruptedException {
        // Arrange
        var request = HttpRequest.newBuilder(URI.create(BASE_URL + "user/repos"))
                .POST(HttpRequest.BodyPublishers.noBody())
                .setHeader("User-Agent", "WB3Tech Bot")
                .build();
        // Act
        var response = httpClient.send(request, HttpResponse.BodyHandlers.discarding());

        //Assert
        var actualStatusCode = response.statusCode();
        assertEquals(401, actualStatusCode);
    }

}

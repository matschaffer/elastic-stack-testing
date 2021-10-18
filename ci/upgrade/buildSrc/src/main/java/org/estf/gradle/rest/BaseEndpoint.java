package org.estf.gradle.rest;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.client.HttpClient;

import java.io.IOException;
import java.util.Base64;

public class BaseEndpoint {

    protected RestUtil utilLib;

    private final String baseUrl;
    private final String endpointPath;
    private final HttpClient client;


    public BaseEndpoint(String baseUrl, String endpointPath) {
        this.baseUrl = baseUrl;
        this.endpointPath = endpointPath;
        this.client = HttpClientBuilder.create().build();
        this.utilLib = new RestUtil();
    }

    protected HttpResponse sendRequest(HttpEntityEnclosingRequestBase request) throws IOException {
        return client.execute(request);
    }

    protected String getBase64EncodedAuth(String username, String password) {
        String credentials = username + ":" + password;
        return  "Basic " + Base64.getEncoder().encodeToString(credentials.getBytes());
    }

    protected String getUrl() {
        return String.format("{}{}", baseUrl, endpointPath);
    }
}

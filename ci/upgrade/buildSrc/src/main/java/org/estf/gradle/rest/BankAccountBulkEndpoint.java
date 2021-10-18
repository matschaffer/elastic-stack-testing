package org.estf.gradle.rest;

import org.apache.http.HttpResponse;

import java.io.IOException;

public class BankAccountBulkEndpoint extends BaseEndpoint {

    private static final String endpointPath = "/bank/account/_bulk?pretty";
    private static final String filePath = "tmp/accounts.json";

    public BankAccountBulkEndpoint(String baseEndpoint) {
        super(baseEndpoint, endpointPath);
    }

    public HttpResponse sendPostFileRequest(String username, String password) throws IOException {
        return sendRequest(utilLib.getPostEntityForFile(getUrl(), getBase64EncodedAuth(username, password), filePath));
    }
}

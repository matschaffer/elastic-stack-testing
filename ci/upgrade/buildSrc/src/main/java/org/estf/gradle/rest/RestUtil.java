package org.estf.gradle.rest;

import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.FileEntity;

import java.io.File;

import static org.estf.gradle.rest.CustomContentType.APPLICATION_NDJSON;

public class RestUtil {

    public HttpPost getPostEntityForFile(String url, String authHeader, String filepath) {
        HttpPost postRequest = new HttpPost(url);
        postRequest.setHeader(HttpHeaders.AUTHORIZATION, authHeader);
        postRequest.setEntity(new FileEntity(new File(filepath),
                ContentType.create(APPLICATION_NDJSON)));
        return postRequest;
    }
}

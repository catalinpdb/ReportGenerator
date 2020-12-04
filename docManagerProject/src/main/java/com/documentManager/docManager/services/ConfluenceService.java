package com.documentManager.docManager.services;

import com.documentManager.docManager.models.ConfluenceReleaseInfo;
import com.documentManager.docManager.models.JiraTicket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class ConfluenceService {

    @Autowired
    private RestTemplate restTemplate;

    public ConfluenceReleaseInfo getConfluenceReleaseInfo(String id) {
        return restTemplate.getForObject(String.format("http://localhost:8080/getConfluenceReleaseInfo/%s",id), ConfluenceReleaseInfo.class);
    }
}

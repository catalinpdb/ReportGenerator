package com.documentManager.docManager.services;

import com.documentManager.docManager.models.JiraTicket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JiraService {

    @Autowired
    private RestTemplate restTemplate;

    public String getJiraTicketsById(String id) {
        JiraTicket[] jiraTicket = restTemplate.getForObject("http://localhost:8080/getJiraTicket/1", JiraTicket[].class);
        return "ok";
    }
}

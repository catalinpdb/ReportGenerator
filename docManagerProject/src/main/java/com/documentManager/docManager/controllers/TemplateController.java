package com.documentManager.docManager.controllers;

import com.documentManager.docManager.models.JiraTicket;
import com.documentManager.docManager.services.JiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class TemplateController {


    @Autowired
    private JiraService jiraService;

    @GetMapping("/generateTER/{id}")
    public JiraTicket[] generateTER(@PathParam("id") String id) {
        return jiraService.getJiraTicketsById(id);
    }

}

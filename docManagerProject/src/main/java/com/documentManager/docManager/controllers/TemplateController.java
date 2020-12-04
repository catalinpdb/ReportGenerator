package com.documentManager.docManager.controllers;

import com.documentManager.docManager.models.JiraTicket;
import com.documentManager.docManager.services.JiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TemplateController {


    @Autowired
    private JiraService jiraService;

    @GetMapping("/generateTER/{id}")
    public void generateTER(@PathVariable String id) throws IOException {
        DocumentGeneratorController.setDocumentTemplate("ter_template.docx");

        for (JiraTicket jiraTicket: jiraService.getJiraTicketsById(id)) {
            List<String> rowCells = new ArrayList<>();
            rowCells.add(jiraTicket.getIssue_key());
            rowCells.add(jiraTicket.getDescription());
            rowCells.add(jiraTicket.getPriority());
            rowCells.add(jiraTicket.getSeverity());
            rowCells.add(jiraTicket.getStatus());
            DocumentGeneratorController.addRowToTable( "Issue type - Key - Summary - Priority - Severity - Status",rowCells);
        }
        DocumentGeneratorController.saveDocument("modified.docx");
    }

}

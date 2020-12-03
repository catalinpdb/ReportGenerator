package com.documentManager.docManager.models;

import lombok.Data;

@Data
public class JiraTicket {
    private String issue_key;
    private String description;
    private String severity;
    private String priority;
    private String status;

    public JiraTicket() {
    }

    public JiraTicket(String issue_key, String description, String severity, String priority, String status) {
        this.issue_key = issue_key;
        this.description = description;
        this.severity = severity;
        this.priority = priority;
        this.status = status;
    }
}

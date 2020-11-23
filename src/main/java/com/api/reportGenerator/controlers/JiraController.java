package com.api.reportGenerator.controlers;

import com.api.reportGenerator.model.JiraTicket;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JiraController {

    @GetMapping("/infoMessage")
    String getInfoMessage(String NARID) {
        return "test-info-message";
    }


    @GetMapping("/getJiraTickets")
    List<JiraTicket> getJiraTickets(){
        List<JiraTicket> jiraTickets = new ArrayList<>();
        JiraTicket jiraTicket = new JiraTicket("issue_key1","description1","severity1", "priority1", "status");
        jiraTickets.add(jiraTicket);
        return jiraTickets;
    }


  // to create a new controller that has path param called NARID (possible values 1234, 4567, 7890)
    // for 1234 we will return a list with 5 different jira tickets
    // for 4567 we will return a list with 9 different jira tickets
    // for 7890 we will return a list with 12 different jira tickets


    // URL to check https://spring.io/guides/tutorials/rest/

}



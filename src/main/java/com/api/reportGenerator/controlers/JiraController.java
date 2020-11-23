package com.api.reportGenerator.controlers;

import com.api.reportGenerator.model.JiraTicket;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class JiraController {
    List<JiraTicket> jiraTickets = new ArrayList<>();

    {
        JiraTicket jiraTicket1 = new JiraTicket("1","description1","severity1", "priority1", "status1");
        JiraTicket jiraTicket2 = new JiraTicket("2","description2","severity2", "priority2", "status2");
        JiraTicket jiraTicket3 = new JiraTicket("1","description3","severity3", "priority3", "status3");
        JiraTicket jiraTicket4 = new JiraTicket("3","description4","severity4", "priority4", "status4");
        jiraTickets.add(jiraTicket1);
        jiraTickets.add(jiraTicket2);
        jiraTickets.add(jiraTicket3);
        jiraTickets.add(jiraTicket4);
    }

    @GetMapping("/infoMessage")
    String getInfoMessage(String NARID) {
        return "test-info-message";
    }

    @GetMapping("/getJiraTickets")
    List<JiraTicket> getJiraTickets(){
        return jiraTickets;
    }

    @GetMapping("/getJiraTicket/{id}")
    Set<JiraTicket> getJiraTicketsById(@PathVariable String id){
        return jiraTickets.stream().filter(ticket_id -> ticket_id.getIssue_key().equals(id)).collect(Collectors.toSet());

    }

  // to create a new controller that has path param called NARID (possible values 1234, 4567, 7890)
    // for 1234 we will return a list with 5 different jira tickets
    // for 4567 we will return a list with 9 different jira tickets
    // for 7890 we will return a list with 12 different jira tickets


    // URL to check https://spring.io/guides/tutorials/rest/

}



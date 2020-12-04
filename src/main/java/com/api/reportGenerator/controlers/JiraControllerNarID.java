package com.api.reportGenerator.controlers;

import com.api.reportGenerator.model.JiraTicket;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
public class JiraControllerNarID {

    @GetMapping("/getJiraTicketsByNarID/{narID}")
    List<JiraTicket> getJiraTickets(@PathVariable String narID){
        List<JiraTicket> jiraTickets = new ArrayList<>();

        switch (narID) {
            case"1234":
                for ( int i=1; i<6 ; i++) {
                    jiraTickets.add ( new JiraTicket("issue_key" + i, "description" + i, "severity" + i, "priority" +i, "status" + i));
                }
                break;
            case "4567":
                for ( int i=6; i<16 ; i++) {
                    jiraTickets.add ( new JiraTicket("issue_key" + i, "description" + i, "severity" + i, "priority" +i, "status" + i));
                }
                break;
            case "7891":
                for ( int i=16; i<28 ; i++) {
                    jiraTickets.add ( new JiraTicket("issue_key" + i, "description" + i, "severity" + i, "priority" +i, "status" + i));
                }
                break;
        }
        return jiraTickets;
    }
}

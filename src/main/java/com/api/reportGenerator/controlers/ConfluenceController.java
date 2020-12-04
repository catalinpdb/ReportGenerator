package com.api.reportGenerator.controlers;

import com.api.reportGenerator.model.ConfluenceReleaseInfo;
import com.api.reportGenerator.model.JiraTicket;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ConfluenceController {
    @GetMapping("/getConfluenceReleaseInfo/{narID}")
    List<ConfluenceReleaseInfo> getConfluenceInfo(@PathVariable String narID){
        List<ConfluenceReleaseInfo> confluenceInfo = new ArrayList<>();

        switch (narID) {
            case"1234":
                for ( int i=1; i<6 ; i++) {
                    confluenceInfo.add ( new ConfluenceReleaseInfo("releaseDate"+i, "region"+i, "releaseNumber" +i, "appName"+i));
                }
                break;
            case "4567":
                for ( int i=6; i<16 ; i++) {
                    confluenceInfo.add ( new ConfluenceReleaseInfo("releaseDate"+i, "region"+i, "releaseNumber" +i, "appName"+i));
                }
                break;
            case "7891":
                for ( int i=16; i<28 ; i++) {
                    confluenceInfo.add ( new ConfluenceReleaseInfo("releaseDate"+i, "region"+i, "releaseNumber" +i, "appName"+i));
                }
                break;
        }
        return confluenceInfo;
    }
}

package com.documentManager.docManager.models;

import lombok.Data;

@Data
public class ConfluenceReleaseInfo {
    private String releaseDate;
    private String region;
    private String releaseNumber;
    private String appName;

    public ConfluenceReleaseInfo() {

    }

    public ConfluenceReleaseInfo(String releaseDate, String region, String releaseNumber, String appName) {
        this.releaseDate = releaseDate;
        this.region = region;
        this.releaseNumber = releaseNumber;
        this.appName = appName;
    }

}

package com.documentManager.docManager;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class DocManagerApplication {
    static XWPFDocument document;

    public static void main(String[] args) throws IOException {
        SpringApplication.run(DocManagerApplication.class, args);
    }
}


package com.documentManager.docManager;

import com.documentManager.docManager.services.JiraService;
import org.apache.poi.xwpf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class DocManagerApplication {
    static XWPFDocument document;

    public static void main(String[] args) throws IOException {
        SpringApplication.run(DocManagerApplication.class, args);

        File docxDoc = new File("ter_template.docx");
        FileInputStream fis = new FileInputStream(docxDoc.getAbsolutePath());
        document = new XWPFDocument(fis);

        XWPFParagraph para = document.getParagraphs().stream().filter(p -> p.getText().contains("NAR_ID")).findFirst().get();
        List<XWPFRun> runs = para.getRuns();
        if (runs != null) {
            for (XWPFRun run : runs) {
                String text = run.getText(0);
                if (text.contains("NAR_ID")) {
                    run.setText("ererer", 0);
                }
            }
        }

        String jiraTableHeader = "Issue type - Key - Summary - Priority - Severity - Status";

        XWPFTable jiraTable = findTableByHeader(jiraTableHeader);

        XWPFTableRow row = jiraTable.createRow();
        row.getCell(0).setText("jiraIssue type");
        row.getCell(1).setText("jiraIssue key");
        row.getCell(2).setText("jiraIssue summary");
        row.getCell(3).setText("jiraIssue priority");
        row.getCell(4).setText("jiraIssue severity");
        row.getCell(5).setText("jiraIssue status");

        String output = "modified.docx";

        FileOutputStream out = new FileOutputStream(output);
        document.write(out);
        out.close();
        document.close();

    }

    public static XWPFTable findTableByHeader(String header) {
        return document.getTables().stream().filter(
                table -> table.getText().replace("\t", " - ").replace("\n", "").equals(header))
                .findFirst().get();
    }
}


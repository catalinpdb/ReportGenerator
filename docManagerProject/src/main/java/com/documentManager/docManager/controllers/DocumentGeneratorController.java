package com.documentManager.docManager.controllers;

import org.apache.poi.xwpf.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class DocumentGeneratorController {
    private static XWPFDocument document;

    public static void saveDocument(String outputFileName) throws IOException {
        FileOutputStream out = new FileOutputStream(outputFileName);
        document.write(out);
        out.close();
        document.close();
    }

    public static void addRowToTable(String tableHeader, List<String> rowCells) {
        XWPFTable table = findTableByHeader(tableHeader);
        XWPFTableRow row = table.createRow();
        for (int i = 0; i < rowCells.size(); i++) {
            row.getCell(i).setText(rowCells.get(i));
        }
    }

    public static void setDocumentTemplate(String templatePath) throws IOException {
        File docxDoc = new File(templatePath);
        FileInputStream fis = new FileInputStream(docxDoc.getAbsolutePath());
        document = new XWPFDocument(fis);
    }

    public static void replaceTextInParagraph(String textToReplace, String newValue) {
        XWPFParagraph para = document.getParagraphs().stream().filter(p -> p.getText().contains(textToReplace)).findFirst().get();
        List<XWPFRun> runs = para.getRuns();
        if (runs != null) {
            for (XWPFRun run : runs) {
                String text = run.getText(0);
                if (text.contains(textToReplace)) {
                    run.setText(newValue, 0);
                }
            }
        }
    }

    private static XWPFTable findTableByHeader(String header) {
        return document.getTables().stream().filter(
                table -> table.getText().replace("\t", " - ").replace("\n", "").equals(header))
                .findFirst().get();
    }
}

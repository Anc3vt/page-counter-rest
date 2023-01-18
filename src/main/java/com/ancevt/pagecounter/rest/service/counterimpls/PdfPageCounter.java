package com.ancevt.pagecounter.rest.service.counterimpls;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

@Service
public class PdfPageCounter implements PageCounter {

    @Override
    public int count(Path path) {
        try (PDDocument doc = PDDocument.load(new File(path.toString()))) {
            return doc.getNumberOfPages();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

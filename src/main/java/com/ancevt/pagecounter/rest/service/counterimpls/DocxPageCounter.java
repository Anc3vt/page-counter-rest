package com.ancevt.pagecounter.rest.service.counterimpls;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Path;

@Service
public class DocxPageCounter implements PageCounter{

    @Override
    public int count(Path path) {
        try {
            XWPFDocument docx = new XWPFDocument(POIXMLDocument.openPackage(path.toAbsolutePath().toString()));
            return docx.getProperties().getExtendedProperties().getUnderlyingProperties().getPages();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

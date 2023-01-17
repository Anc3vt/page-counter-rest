package com.ancevt.pagecounter.rest.service;

import com.ancevt.pagecounter.rest.pagecounter.DocxPageCounter;
import com.ancevt.pagecounter.rest.pagecounter.PageCounter;
import com.ancevt.pagecounter.rest.pagecounter.PdfPageCounter;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PageCounterServiceImpl implements PageCounterService {

    private static final Map<String, PageCounter> pageCounterImplementations = Map.of(
            "docx", new DocxPageCounter(),
            "pdf", new PdfPageCounter()
            // You can extend content of this map with your own PageCounter implementations
    );

    @Override
    public String getResult(String basePath) throws IOException {
        AtomicInteger documents = new AtomicInteger();
        AtomicInteger pages = new AtomicInteger();

        Files.walk(Path.of(basePath))
                .filter(Files::isRegularFile)
                .forEach(path ->handleDocument(path, documents, pages));

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Documents: %d%n".formatted(documents.get()));
        stringBuilder.append("<br/>");
        stringBuilder.append("Pages: %d%n".formatted(pages.get()));
        return stringBuilder.toString();
    }

    private static void handleDocument(Path path, AtomicInteger documents, AtomicInteger pages) {
        PageCounter pageCounter = pageCounterImplementations.get(getExtension(path));

        if (pageCounter != null) {
            documents.incrementAndGet();
            pages.addAndGet(pageCounter.count(path));
        }
    }

    private static String getExtension(Path path) {
        return FilenameUtils.getExtension(path.toString()).toLowerCase();
    }
}

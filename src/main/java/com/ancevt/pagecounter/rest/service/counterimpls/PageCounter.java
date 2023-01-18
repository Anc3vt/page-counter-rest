package com.ancevt.pagecounter.rest.service.counterimpls;

import java.nio.file.Path;

public interface PageCounter {
    int count(Path path);
}

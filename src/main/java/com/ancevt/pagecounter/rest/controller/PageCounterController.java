package com.ancevt.pagecounter.rest.controller;


import com.ancevt.pagecounter.rest.service.PageCounterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("v1/")
@RequiredArgsConstructor
public class PageCounterController {

    private final PageCounterService pageCounterService;

    @GetMapping("/count")
    private ResponseEntity<String> count(@RequestParam(name = "basePath") String basePath) throws IOException {
        return ResponseEntity.ok(pageCounterService.getResult(basePath));
    }
}

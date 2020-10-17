package com.example.javawebuiatspring.controller;


import com.example.javawebuiatspring.service.FileProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
public class WordsController {

    private FileProcessor fileProcessor;

    public WordsController(FileProcessor fileProcessor) {
        this.fileProcessor = fileProcessor;
    }

    @Value("classpath:lotr.txt")
    Resource lotr;

    @Value("classpath:dune.txt")
    Resource dune;

    @Value("classpath:lorem_1000.txt")
    Resource lorem;

    @GetMapping("/words")
    public Map<String, Long> askAppToCount (@RequestParam String filename) throws IOException {

        Map<String, Long> bookToReturn = null;

        switch (filename) {
            case "lotr":
                bookToReturn = fileProcessor.fileSplitToLines(lotr);
                break;
            case "dune":
                bookToReturn = fileProcessor.fileSplitToLines(dune);
                break;
            case "lorem":
                bookToReturn = fileProcessor.fileSplitToLines(lorem);
                break;
        }
        return bookToReturn;
    }
}

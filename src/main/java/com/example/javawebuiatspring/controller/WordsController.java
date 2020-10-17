package com.example.javawebuiatspring.controller;


import com.example.javawebuiatspring.service.FileProcessor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
public class WordsController {

    @GetMapping("/words")
    public Map<String, Long> askAppToCount (@RequestParam String filename) throws IOException {

        FileProcessor fileProcessor = new FileProcessor();
        Map<String, Long> bookToReturn = null;

        switch (filename) {
            case "lotr":
                bookToReturn = fileProcessor.fileSplitToLines("C:\\Users\\Anton\\IdeaProjects\\java-webui-at-spring\\src\\main\\resources\\lotr.txt");
                break;
            case "dune":
                bookToReturn = fileProcessor.fileSplitToLines("C:\\Users\\Anton\\IdeaProjects\\java-webui-at-spring\\src\\main\\resources\\dune.txt");
                break;
            case "lorem":
                bookToReturn = fileProcessor.fileSplitToLines("C:\\Users\\Anton\\IdeaProjects\\java-webui-at-spring\\src\\main\\resources\\lorem_1000.txt");
                break;
        }
        return bookToReturn;
    }
}

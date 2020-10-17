package com.example.javawebuiatspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

@Service
public class FileProcessor {

    private final WordsCounter wordsCounter;

    public FileProcessor(WordsCounter wordsCounter) {
        this.wordsCounter = wordsCounter;
    }

    public Map<String, Long> fileSplitToLines(Resource book) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(book.getFile()));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        while (line != null) {
            sb.append(line).append("\n");
            line = br.readLine();
        }

        String fileAsString = sb.toString();

        return wordsCounter.countWordsInLine(fileAsString);
    }
}

package com.example.javawebuiatspring.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class FileProcessor {

    public Map<String, Long> fileSplitToLines(String filename) throws IOException {

        File file = new File(filename);

        BufferedReader br = new BufferedReader(new FileReader(file));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        while (line != null) {
            sb.append(line).append("\n");
            line = br.readLine();
        }

        String fileAsString = sb.toString();

        WordsCounter wordsCounter = new WordsCounter();

        return wordsCounter.countWordsInLine(fileAsString);
    }
}

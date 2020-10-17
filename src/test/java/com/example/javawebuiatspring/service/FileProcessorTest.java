package com.example.javawebuiatspring.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;


class FileProcessorTest {

    @Test
    void fileSplitToLines() throws IOException {

        FileProcessor fileProcessor = new FileProcessor();

        Map<String, Long> stringLongMap = fileProcessor.fileSplitToLines("C:\\Users\\Anton\\IdeaProjects\\java-webui-at-spring\\src\\main\\resources\\lotr.txt");

        Assertions.assertNotNull(stringLongMap);
        Assertions.assertEquals(227, stringLongMap.get("sauron").longValue());
        Assertions.assertEquals(1901, stringLongMap.get("frodo").longValue());
        Assertions.assertEquals(2, stringLongMap.get("sword-that-was-broken").longValue());
        Assertions.assertEquals(223, stringLongMap.get("sword").longValue());
    }
}
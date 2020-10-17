package com.example.javawebuiatspring.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Map;

@SpringBootTest
class FileProcessorTest {

    @Value("classpath:lotr.txt")
    Resource lotr;

    @Test
    void fileSplitToLines() throws IOException {

        FileProcessor fileProcessor = new FileProcessor(new WordsCounter());

        Map<String, Long> stringLongMap = fileProcessor.fileSplitToLines(lotr);

        Assertions.assertNotNull(stringLongMap);
        Assertions.assertEquals(227, stringLongMap.get("sauron").longValue());
        Assertions.assertEquals(1901, stringLongMap.get("frodo").longValue());
        Assertions.assertEquals(2, stringLongMap.get("sword-that-was-broken").longValue());
        Assertions.assertEquals(223, stringLongMap.get("sword").longValue());
    }
}
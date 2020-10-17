package com.example.javawebuiatspring.serializer;

import com.example.javawebuiatspring.service.FileProcessor;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;

class JsonWordsSerializerTest {

    @Test
    void serialize() throws IOException {

        FileProcessor fileProcessor = new FileProcessor();

        Map<String, Long> stringLongMap = fileProcessor.fileSplitToLines("C:\\Users\\Anton\\IdeaProjects\\java-webui-at-spring\\src\\main\\resources\\lotr.txt");


        JsonWordsSerializer jsonWordsSerializer = new JsonWordsSerializer();


        jsonWordsSerializer.serialize(stringLongMap, "lotr-serialize.txt");
    }
}
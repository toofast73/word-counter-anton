package com.example.javawebuiatspring.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
import java.io.IOException;
import java.util.Map;


public class JsonWordsSerializer {
    public File serialize(Map<String, Long> mapToSerialize, String filename) {

        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter objectWriter = mapper.writerFor(Map.class);
        File file = new File(filename);
        try {
            objectWriter.writeValue(file, mapToSerialize);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
}

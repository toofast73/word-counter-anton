package com.example.javawebuiatspring.service;



import java.util.*;

public class WordsCounter {

    public Map<String, Long> countWordsInLine(String inputText) {

        List<String> listOfWordsAfterST = new ArrayList<>();

        String lowerCaseInputText = inputText.toLowerCase();

        StringTokenizer st = new StringTokenizer(lowerCaseInputText, " \t\n\r\f,.?!:;|\"(){}[]*+\\@$%&#_=/");

        while(st.hasMoreElements()){
            listOfWordsAfterST.add(st.nextToken());
        }

        HashMap<String, Long> hashMapOfWords = new HashMap<>();

        for(String i : listOfWordsAfterST) {
            Long j = hashMapOfWords.get(i);
            hashMapOfWords.put(i, (j == null) ? 1 : j + 1);
        }

        return hashMapOfWords;
    }
}

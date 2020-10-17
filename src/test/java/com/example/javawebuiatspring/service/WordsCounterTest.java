package com.example.javawebuiatspring.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class WordsCounterTest {

    @Test
    void wordCounter() {

        String shortTestString = "Grut! I am Grut!";
        String mediumTestString = "One | Two Two | Three Three Three | Four Four Four Four | Five Five Five Five";
        WordsCounter wordsCounter = new WordsCounter();

        Assertions.assertNotNull(wordsCounter.countWordsInLine(shortTestString));
        Assertions.assertEquals(3, wordsCounter.countWordsInLine(shortTestString).size());
        Assertions.assertEquals(2, wordsCounter.countWordsInLine(shortTestString).get("grut").longValue());

        Assertions.assertNotNull(wordsCounter.countWordsInLine(mediumTestString));
        Assertions.assertEquals(5, wordsCounter.countWordsInLine(mediumTestString).size());
        Assertions.assertEquals(4, wordsCounter.countWordsInLine(mediumTestString).get("four").longValue());
    }
}
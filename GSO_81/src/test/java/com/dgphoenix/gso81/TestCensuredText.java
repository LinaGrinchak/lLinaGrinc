package com.dgphoenix.gso81;

import org.junit.Test;

public class TestCensuredText {
    String censuredWord = "краб";
    String text = "Краб крабу сделал грабли, подарил грабли крабу: «Грабь граблями гравий, краб».";

    private void censuredTest(String censuredWord, String text) {
        System.out.println(Censured.class.getName() + ":");
        try {
            Censured censured = new Censured(censuredWord);
            System.out.println("censure: " + censured.censure(text));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void doTestCensuredOfGivenText() {
        System.out.println("Censored of given text:");
        censuredTest(censuredWord, text);
    }

    @Test
    public void doTestCensuredWordNull() {
        System.out.println("Censored Word null:");
        censuredTest(null, "Censored Spaces:");
    }

    @Test
    public void doTestCensuredWordEmpty() {
        System.out.println("Censored Word Empty:");
        censuredTest("", "Censored   Spaces:");
    }

    @Test
    public void doTestCensuredWordSpaces() {
        System.out.println("Censored Word Spaces:");
        censuredTest("     ", "Censored   Spaces:");
    }

    @Test
    public void doTestCensuredHyphenatedWordText() {
        System.out.println("Censured Hyphenated Word Tex:");
        censuredTest("ЖАДИНА-ГОВЯДИНА", "Жадина-говядина – / Солёный огурец, / На полу валяется, / Никого не ест.");
    }

    @Test
    public void doTestCensuredPhraseText() {
        System.out.println("Censured Phrase in Text:");
        censuredTest("РЕВА КОРОВА", " Рева корова ДАЙ МОЛОКА");
    }

    @Test
    public void doTestCensuredCommonWordInText() {
        System.out.println("Censured Common Word In Text:");
        censuredTest("idler", "Idler - a habitually lazy person.");
    }

    @Test
    public void doTestCensoredWordNextToPunctuation() {
        System.out.println("Censored Word Next To Punctuation:");
        censuredTest("fool", "He is a running fool.");
    }

    @Test
    public void doTestCensoredOfWordBrokenBySymbols() {
        System.out.println("Censored Of Word Broken By Symbols:");
        censuredTest("fool", "4f-o-o_lTT.");
    }

    @Test
    public void doTestCensoredRepeat() {
        System.out.println("Censored Repeat:");
        censuredTest("fool", "4f-o-o_lTTFool.");
    }

    @Test
    public void doTestNullText() {
        System.out.println("Censored null:");
        censuredTest("fool", null);
    }

    @Test
    public void doTestWithoutText() {
        System.out.println("Censored Without Text:");
        censuredTest("fool", "");
    }

    @Test
    public void doTestTextSpaces() {
        System.out.println("Censored Spaces:");
        censuredTest("fool", "        ");
    }
}

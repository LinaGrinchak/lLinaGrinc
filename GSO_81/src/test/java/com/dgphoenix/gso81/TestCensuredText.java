package com.dgphoenix.gso81;

import org.junit.Assert;
import org.junit.Test;

public class TestCensuredText {
    private String censuredTest(String censuredWord, String text) throws Exception {
        Censured censured = new Censured(censuredWord);
        return censured.censure(text);
    }

    @Test
    public void isCensuredWordNull() {
        try {
            censuredTest(null, "Censored Spaces:");
            Assert.fail("Expected Exception");
        } catch (Exception thrown) {
            Assert.assertEquals("Censored word empty", thrown.getMessage());
        }
    }

    @Test
    public void isCensuredWordEmpty() {
        try {
            censuredTest("", "Censored Spaces:");
            Assert.fail("Expected Exception");
        } catch (Exception thrown) {
            Assert.assertEquals("Censored word empty", thrown.getMessage());
        }
    }

    @Test
    public void isCensuredWordSpaces() {
        try {
            censuredTest("     ", "Censored   Spaces:");
            Assert.fail("Expected Exception");
        } catch (Exception thrown) {
            Assert.assertEquals("Censored word empty", thrown.getMessage());
        }
    }

    @Test
    public void isCensuredTextEmpty() throws Exception {
        String censuredWord = "wold";
        String text = "";
        String expectedText = "";
        Assert.assertEquals(expectedText, censuredTest(censuredWord, text));
    }

    @Test
    public void isCensuredTextNull() throws Exception {
        String censuredWord = "wold";
        String text = null;
        String expectedText = "";
        Assert.assertEquals(expectedText, censuredTest(censuredWord, text));
    }

    @Test
    public void isCensuredTextSpaces() throws Exception {
        String censuredWord = "wold";
        String text = "      ";
        String expectedText = "";
        Assert.assertEquals(expectedText, censuredTest(censuredWord, text));
    }

    @Test
    public void isCensuredOfGivenText() throws Exception {
        String censuredWord = "краб";
        String text = "Краб крабу сделал грабли, подарил грабли крабу: «Грабь граблями гравий, краб».";
        String expectedText = "censored крабу сделал грабли, подарил грабли крабу: «Грабь граблями гравий, краб».";
        Assert.assertEquals(expectedText, censuredTest(censuredWord, text));
    }
}

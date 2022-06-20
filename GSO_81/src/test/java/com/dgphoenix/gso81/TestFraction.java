package com.dgphoenix.gso81;

import org.junit.Assert;
import org.junit.Test;

public class TestFraction {
    @Test
    public void isNull() {
        try {
            Fraction fraction = new Fraction(null);
            Assert.fail("Expected Exception");
        } catch (Exception thrown) {
            Assert.assertEquals(null, thrown.getMessage());
        }
    }

    @Test
    public void isEmpty() {
        try {
            Fraction fraction = new Fraction("");
            Assert.fail("Expected Exception");
        } catch (Exception thrown) {
            Assert.assertEquals("Numerator entered incorrectly", thrown.getMessage());
        }
    }

    @Test
    public void isAllEmpty() {
        try {
            Fraction fraction = new Fraction("/");
            Assert.fail("Expected Exception");
        } catch (Exception thrown) {
            Assert.assertEquals("Fraction entered incorrectly", thrown.getMessage());
        }
    }

    @Test
    public void isNumeratorEmpty() {
        try {
            Fraction fraction = new Fraction("/1");
            Assert.fail("Expected Exception");
        } catch (Exception thrown) {
            Assert.assertEquals("Numerator entered incorrectly", thrown.getMessage());
        }
    }

    @Test
    public void isDenominatorEmpty() {
        try {
            Fraction fraction = new Fraction("1/");
        } catch (Exception thrown) {
            Assert.assertEquals("Denominator entered incorrectly", thrown.getMessage());
        }
    }

    @Test
    public void isWrongInputFraction() {
        try {
            Fraction fraction = new Fraction("$ a 4t gd");
            Assert.fail("Expected Exception");
        } catch (Exception thrown) {
            Assert.assertEquals("For input string: \"$ a 4t gd\"", thrown.getMessage());
        }
    }

    @Test
    public void isWrongNumerator() {
        try {
            Fraction fraction = new Fraction("f/4");
            Assert.fail("Expected Exception");
        } catch (Exception thrown) {
            Assert.assertEquals("For input string: \"f\"", thrown.getMessage());
        }
    }

    @Test
    public void isWrongDenominator() {
        try {
            Fraction fraction = new Fraction("1/d");
            Assert.fail("Expected Exception");
        } catch (Exception thrown) {
            Assert.assertEquals("For input string: \"d\"", thrown.getMessage());
        }
    }

    @Test
    public void isExcessNumerator() {
        try {
            Fraction fraction = new Fraction("2147483649/2147483640");
            Assert.fail("Expected Exception");
        } catch (Exception thrown) {
            Assert.assertEquals("For input string: \"2147483649\"", thrown.getMessage());
        }
    }

    @Test
    public void isExcessDenominator() {
        try {
            Fraction fraction = new Fraction("2147483640/2147483649");
            Assert.fail("Expected Exception");
        } catch (Exception thrown) {
            Assert.assertEquals("For input string: \"2147483649\"", thrown.getMessage());
        }
    }


    @Test
    public void isEnteredInteger() throws Exception {
        String expected = "5/1";
        Fraction fraction = new Fraction("5");
        Assert.assertEquals(expected, fraction.toString());
    }

    @Test
    public void isMinusNumerator() throws Exception {
        String expected = "-1/3";
        Fraction fraction = new Fraction("-5/15");
        Assert.assertEquals(expected, fraction.toString());
    }

    @Test
    public void isMinusDenominator() throws Exception {
        String expected = "-1/3";
        Fraction fraction = new Fraction("5/-15");
        Assert.assertEquals(expected, fraction.toString());
    }

    @Test
    public void isDoubleMinus() throws Exception {
        String expected = "1/3";
        Fraction fraction = new Fraction("-5/-15");
        Assert.assertEquals(expected, fraction.toString());
    }


    @Test
    public void isAdd() throws Exception {
        Fraction fraction = new Fraction("-5/30");
        Fraction fraction2 = new Fraction("5/18");
        String expected = "1/9";
        Assert.assertEquals(expected, fraction.add(fraction2).toString());
    }

    @Test
    public void isExcessAdd() throws Exception {
        Fraction fraction = new Fraction("-5/2147483640");
        Fraction fraction2 = new Fraction("5/18");
        try {
            fraction.add(fraction2);
            Assert.fail("Expected Exception");
        } catch (Exception thrown) {
            Assert.assertEquals("Number out of bounds for Integer values", thrown.getMessage());
        }
    }

    @Test
    public void isSubtract() throws Exception {
        Fraction fraction = new Fraction("-5/30");
        Fraction fraction2 = new Fraction("5/18");
        String expected = "-4/9";
        Assert.assertEquals(expected, fraction.subtract(fraction2).toString());
    }

    @Test
    public void isExcessSubtract() throws Exception {
        Fraction fraction = new Fraction("-5/2147483640");
        Fraction fraction2 = new Fraction("5/18");
        try {
            fraction.subtract(fraction2);
            Assert.fail("Expected Exception");
        } catch (Exception thrown) {
            Assert.assertEquals("Number out of bounds for Integer values", thrown.getMessage());
        }
    }

    @Test
    public void isMultiply() throws Exception {
        Fraction fraction = new Fraction("-9/30");
        Fraction fraction2 = new Fraction("5/18");
        String expected = "-1/12";
        Assert.assertEquals(expected, fraction.multiply(fraction2).toString());
    }

    @Test
    public void isExcessMultiply() throws Exception {
        Fraction fraction = new Fraction("-5/2147483640");
        Fraction fraction2 = new Fraction("5/18");
        try {
            fraction.multiply(fraction2);
            Assert.fail("Expected Exception");
        } catch (Exception thrown) {
            Assert.assertEquals("Number out of bounds for Integer values", thrown.getMessage());
        }
    }

    @Test
    public void isDivided() throws Exception {
        Fraction fraction = new Fraction("-9/30");
        Fraction fraction2 = new Fraction("5/18");
        String expected = "-27/25";
        Assert.assertEquals(expected, fraction.divided(fraction2).toString());
    }

    @Test
    public void isExcessDivided() throws Exception {
        Fraction fraction = new Fraction("-5/2147483640");
        Fraction fraction2 = new Fraction("170/18");
        try {
            fraction.divided(fraction2);
            Assert.fail("Expected Exception");
        } catch (Exception thrown) {
            Assert.assertEquals("Number out of bounds for Integer values", thrown.getMessage());
        }
    }
}

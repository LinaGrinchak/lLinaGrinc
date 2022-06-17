package com.dgphoenix.gso81;

import org.junit.Test;

public class TestFraction {
    String fractionStr1 = "6/8";
    String fractionStr2 = "-6/57";

    private void createFraction(String fractionStr) {
        System.out.println(StringUtils.class.getName() + ":");
        System.out.println("Input fraction: " + fractionStr);
        try {
            Fraction fraction = new Fraction(fractionStr);
            System.out.println("fraction: " + fraction);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sumFractions(String fractionStr1, String fractionStr2) {
        System.out.println(StringUtils.class.getName() + ":");
        System.out.println("Input fraction 1: " + fractionStr1 + " Input fraction 2: " + fractionStr2);
        try {
            Fraction fraction1 = new Fraction(fractionStr1);
            Fraction fraction2 = new Fraction(fractionStr2);
            System.out.println(fraction1 + "+" + fraction2 + "=" + fraction1.add(fraction2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void subtractFractions(String fractionStr1, String fractionStr2) {
        System.out.println(StringUtils.class.getName() + ":");
        System.out.println("Input fraction 1: " + fractionStr1 + " Input fraction 2: " + fractionStr2);
        try {
            Fraction fraction1 = new Fraction(fractionStr1);
            Fraction fraction2 = new Fraction(fractionStr2);
            System.out.println(fraction1 + "-" + fraction2 + "=" + fraction1.subtract(fraction2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void multiplyFractions(String fractionStr1, String fractionStr2) {
        System.out.println(StringUtils.class.getName() + ":");
        System.out.println("Input fraction 1: " + fractionStr1 + " Input fraction 2: " + fractionStr2);
        try {
            Fraction fraction1 = new Fraction(fractionStr1);
            Fraction fraction2 = new Fraction(fractionStr2);
            System.out.println(fraction1 + "*" + fraction2 + "=" + fraction1.multiply(fraction2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void dividedFractions(String fractionStr1, String fractionStr2) {
        System.out.println(StringUtils.class.getName() + ":");
        System.out.println("Input fraction 1: " + fractionStr1 + " Input fraction 2: " + fractionStr2);
        try {
            Fraction fraction1 = new Fraction(fractionStr1);
            Fraction fraction2 = new Fraction(fractionStr2);
            System.out.println(fraction1 + "/" + fraction2 + "=" + fraction1.divided(fraction2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void doTestInputFraction() {
        createFraction(fractionStr1);
    }

    @Test
    public void doTestWrongString() {
        createFraction("$ a 4t gd");
    }

    @Test
    public void doTestWrongNumerator() {
        createFraction("f/4");
    }

    @Test
    public void doTestWrongDenominator() {
        createFraction("1/d");
    }

    @Test
    public void doTestInt() {
        createFraction("5");
    }

    @Test
    public void doTestNull() {
        createFraction(null);
    }

    @Test
    public void doTestMinusNumerator() {
        createFraction("-6/5");
    }

    @Test
    public void doTestMinusDenominator() {
        createFraction("3/-5");
    }

    @Test
    public void doTestDoubleMinus() {
        createFraction("-3/-4");
    }

    @Test
    public void doTestAdd() {
        sumFractions("5/8", "3/12");
    }

    @Test
    public void doTestInputFractionAdd() {
        sumFractions(fractionStr1, fractionStr2);
    }

    @Test
    public void doTestMultiply() {
        multiplyFractions("5/8", "11/12");
    }

    @Test
    public void doTestInputMultiply() {
        multiplyFractions(fractionStr1, fractionStr2);
    }

    @Test
    public void doTestSubtract() {
        subtractFractions("5/8", "11/12");
    }

    @Test
    public void doTestInputFractionSubtract() {
        subtractFractions(fractionStr1, fractionStr2);
    }

    @Test
    public void doTestDivided() {
        dividedFractions("5/8", "0/12");
    }

    @Test
    public void doTestInputFractionDivided() {
        dividedFractions(fractionStr1, fractionStr2);
    }

    @Test
    public void doTestSubtractExceeding() {
        subtractFractions("2147483647/8", "-1000/12");
    }

    @Test
    public void doTestInputFractionExceeding() {
        dividedFractions("2147483647/8", "2147483647/8");
    }
}

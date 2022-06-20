package com.dgphoenix.gso81;

import java.util.Arrays;

import static java.lang.Integer.compare;
import static java.lang.Math.abs;

public class Fraction implements Comparable<Fraction> {
    private static final int MAX = 2147483647;
    private static final String DIVIDED = "/";
    private static final String MESSAGE_EXCEPTION_NUMBER = "Number out of bounds for Integer values";
    private int numerator;
    private int denominator;

    Fraction(int numerator, int denominator) throws Exception {
        createFraction(numerator, denominator);
    }

    Fraction(String fraction) throws Exception {
        String[] strArray = fraction.split(DIVIDED);
        int lengthArray = strArray.length;
        if (lengthArray == 0 || lengthArray > 2) {
            throw new Exception("Fraction entered incorrectly");
        } else if (lengthArray == 1) {
            if (strArray[0].isEmpty()) {
                throw new Exception("Numerator entered incorrectly");
            }
            createFraction(Integer.parseInt(strArray[0]), 1);
        } else if (lengthArray == 2) {
            if (strArray[0].isEmpty()) {
                throw new Exception("Numerator entered incorrectly");
            }
            if (strArray[1].isEmpty()) {
                throw new Exception("Denominator entered incorrectly");
            }
            createFraction(Integer.parseInt(strArray[0]), Integer.parseInt(strArray[1]));
        }
    }

    public Fraction add(Fraction term) throws Exception {
        int newDenominator = doLCM(denominator, term.denominator);
        int multiplier1 = newDenominator / denominator;
        int multiplier2 = newDenominator / term.denominator;
        checkExceptionsForIntMultiply(numerator, multiplier1);
        checkExceptionsForIntMultiply(term.numerator, multiplier2);
        int multiplicated1 = numerator * multiplier1;
        int multiplicated2 = term.numerator * multiplier2;
        if (abs(MAX - multiplicated1) < abs(multiplicated2)) {
            throw new Exception(MESSAGE_EXCEPTION_NUMBER);
        }
        int newNumerator = multiplicated1 + multiplicated2;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction subtract(Fraction subtrahend) throws Exception {
        return this.add(new Fraction(-subtrahend.numerator, subtrahend.denominator));
    }

    public Fraction multiply(Fraction multiplier) throws Exception {
        if (isWithinIntegersMultiply(numerator, multiplier.numerator) && isWithinIntegersMultiply(denominator, multiplier.denominator)) {
            return this.multiplyFractions(multiplier);
        }
        Fraction f1 = new Fraction(numerator, multiplier.denominator);
        Fraction f2 = new Fraction(multiplier.numerator, denominator);
        checkExceptionsForIntMultiply(f1.numerator, f2.numerator);
        checkExceptionsForIntMultiply(f1.denominator, f2.denominator);
        return f1.multiplyFractions(f2);
    }

    private static void checkExceptionsForIntMultiply(int num1, int num2) throws Exception {
        if (!isWithinIntegersMultiply(num1, num2))
            throw new Exception(MESSAGE_EXCEPTION_NUMBER);
    }

    public Fraction divided(Fraction divisor) throws Exception {
        return this.multiply(new Fraction(divisor.denominator, divisor.numerator));
    }

    private void createFraction(int numerator, int denominator) throws Exception {
        if (denominator == 0) {
            throw new Exception("Denominator must not be 0");
        }
        int gcd = doGCD(numerator, denominator);
        int newNumerator = numerator / gcd;
        int newDenominator = denominator / gcd;
        boolean isPositiveNumber = newDenominator > 0;
        this.numerator = isPositiveNumber ? newNumerator : (newNumerator * -1);
        this.denominator = isPositiveNumber ? newDenominator : abs(newDenominator);
    }

    private static boolean isWithinIntegersMultiply(int b, int a) {
        return abs(MAX) / abs(b) >= abs(a);
    }

    private Fraction multiplyFractions(Fraction multiplier) throws Exception {
        int newNumerator = numerator * multiplier.numerator;
        int newDenominator = denominator * multiplier.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    private static int doGCD(int num1, int num2) {
        return (num2 == 0) ? num1 : doGCD(num2, num1 % num2);
    }

    private static int doLCM(int num1, int num2) throws Exception {
        checkExceptionsForIntMultiply(num1, num2);
        return num1 * num2 / doGCD(num1, num2);
    }

    @Override
    public int compareTo(Fraction o) {
        return compare(numerator * o.denominator, o.numerator * denominator);
    }

    @Override
    public String toString() {
        return numerator + DIVIDED + denominator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction fractionalNumber = (Fraction) o;
        return numerator * fractionalNumber.denominator == fractionalNumber.numerator * denominator;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(new int[]{numerator, denominator});
    }
}

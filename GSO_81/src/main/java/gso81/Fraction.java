package gso81;

import java.util.Arrays;

import static java.lang.Integer.compare;
import static java.lang.Math.abs;

public class Fraction implements Comparable<Fraction> {
    private static int MAX = 2147483647;
    private static String DIVIDED = "/";
    private int numerator;
    private int denominator;

    Fraction(int numerator, int denominator) throws Exception {
        createFraction(numerator, denominator);
    }

    Fraction(String fraction) throws Exception {
        String[] strArray = fraction.split(DIVIDED);
        if (strArray.length == 1) {
            createFraction(Integer.parseInt(strArray[0]), 1);
        } else if (strArray.length == 2) {
            createFraction(Integer.parseInt(strArray[0]), Integer.parseInt(strArray[1]));
        } else {
            throw new Exception("Fraction entered incorrectly");
        }
    }

    public Fraction add(Fraction term) throws Exception {
        this.simplify();
        term.simplify();
        int newDenominator = doLCM(denominator, term.denominator);
        int multiplier1 = newDenominator / denominator;
        int multiplier2 = newDenominator / term.denominator;
        if (isWithinIntegersMultiply(numerator, multiplier1) && isWithinIntegersMultiply(term.numerator, multiplier2)) {
            int multiplicated1 = numerator * multiplier1;
            int multiplicated2 = term.numerator * multiplier2;
            if (abs(MAX - multiplicated1) >= abs(multiplicated2)) {
                int newNumerator = multiplicated1 + multiplicated2;
                return new Fraction(newNumerator, newDenominator).simplify();
            } else {
                throw new Exception("Fraction entered incorrectly");

            }
        } else {
            throw new Exception("Fraction entered incorrectly");

        }
    }

    public Fraction subtract(Fraction subtrahend) throws Exception {
        return this.add(new Fraction(-subtrahend.numerator, subtrahend.denominator));
    }

    public Fraction multiply(Fraction multiplier) throws Exception {
        this.simplify();
        multiplier.simplify();
        if (isWithinIntegersMultiply(numerator, multiplier.numerator) && isWithinIntegersMultiply(denominator, multiplier.denominator)) {
            return this.multiplyFractions(multiplier);
        } else {
            Fraction f1 = new Fraction(numerator, multiplier.denominator).simplify();
            Fraction f2 = new Fraction(multiplier.numerator, denominator).simplify();
            if (isWithinIntegersMultiply(numerator, multiplier.numerator) && isWithinIntegersMultiply(denominator, multiplier.denominator)) {
                return f1.multiplyFractions(f2);
            } else {
                throw new Exception("Number out of bounds for Integer values");
            }
        }
    }

    public Fraction divided(Fraction divisor) throws Exception {
        return this.multiply(new Fraction(divisor.denominator, divisor.numerator));
    }

    private void createFraction(int numerator, int denominator) throws Exception {
        if (denominator == 0) {
            throw new Exception("Denominator must not be 0");
        }
        if (denominator > 0) {
            this.numerator = numerator;
            this.denominator = denominator;
        } else {
            this.numerator = numerator * -1;
            this.denominator = abs(denominator);
        }
    }

    private static boolean isWithinIntegersMultiply(int b, int a) {
        return abs(MAX) / b >= abs(a);
    }

    private Fraction multiplyFractions(Fraction multiplier) throws Exception {
        int newNumerator = numerator * multiplier.numerator;
        int newDenominator = denominator * multiplier.denominator;
        return new Fraction(newNumerator, newDenominator).simplify();
    }

    private Fraction simplify() throws Exception {
        int gcd = doGCD(numerator, denominator);
        int newNumerator = numerator / gcd;
        int newDenominator = denominator / gcd;
        return new Fraction(newNumerator, newDenominator);
    }

    @Override
    public int compareTo(Fraction o) {
        return compare(numerator * o.denominator, o.numerator * denominator);
    }

    private static int doGCD(int a, int b) {
        if (b == 0)
            return a;
        else
            return doGCD(b, a % b);
    }

    private static int doLCM(int a, int b) throws Exception {
        if (isWithinIntegersMultiply(a, b)) {
            return a * b / doGCD(a, b);
        } else {
            throw new Exception("Number out of bounds for Integer values");
        }
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

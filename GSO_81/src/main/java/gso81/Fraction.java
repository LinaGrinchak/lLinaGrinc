package gso81;

import java.util.Arrays;
import static java.lang.Integer.compare;
import static java.lang.Math.abs;

public class Fraction implements Comparable<Fraction> {
    private int numerator;
    private int denominator;

    Fraction(int numerator, int denominator) throws Exception {
        createFraction(numerator, denominator);
    }

    Fraction(String fraction) throws Exception {
        String[] strArray = fraction.split("/");
        if (strArray.length != 2) {
            throw new Exception("Fraction entered incorrectly");
        } else {
            createFraction(Integer.parseInt(strArray[0]), Integer.parseInt(strArray[1]));
        }
    }

    public Fraction add(Fraction term) throws Exception {
        int newDenominator = doLCM(denominator, term.denominator);
        int newNumerator = numerator * newDenominator / denominator + term.numerator * newDenominator / term.denominator;
        return simplify(new Fraction(newNumerator, newDenominator));
    }

    public Fraction subtract(Fraction subtrahend) throws Exception {
        return this.add(new Fraction(-subtrahend.numerator, subtrahend.denominator));
    }

    public Fraction multiply(Fraction multiplier) throws Exception {
        int newNumerator = numerator * multiplier.numerator;
        int newDenominator = denominator * multiplier.denominator;
        return simplify(new Fraction(newNumerator, newDenominator));
    }

    public Fraction divided(Fraction dividend, Fraction divisor) throws Exception {
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

    private static Fraction simplify(Fraction fraction) throws Exception {
        int gcd = doGCD(fraction.numerator, fraction.denominator);
        int newNumerator = fraction.numerator / gcd;
        int newDenominator = fraction.denominator / gcd;
        return new Fraction(newNumerator, newDenominator);
    }

    @Override
    public int compareTo(Fraction o) {
        return compare(numerator * o.denominator, o.numerator * denominator);
    }

    private static int doGCD(int a, int b)/* Алгоритм Евклида */// Используется для нахождения наибольшего общего делителя
    {
        if (b == 0)
            return a;
        else
            return doGCD(b, a % b);
    }

    private static int doLCM(int a, int b)  // НОК
    {
        return a * b / doGCD(a, b);
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(numerator).append("/").append(denominator);
        return result.toString();
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
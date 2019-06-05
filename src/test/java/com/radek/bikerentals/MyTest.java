package com.radek.bikerentals;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import java.util.Arrays;

public class MyTest {

    @Test
    public void twoPlusThreeShouldBeFive() {
        assertEquals(5, 2+3);
    }

    @Test
    public void twoStringsShouldBeEqual () {
        String a = "a";
        String b = "a";

        assertEquals("jbjkj", a, b);
    }


    @Test
    public void shouldCountCapitalLetters() {

        assertEquals("should be 5", 5, countCapitalLetter("aAAaAAAa"));
        assertEquals("should be 3", 3, countCapitalLetter("aaAaaAaAa"));
        assertEquals("should be 4", 4, countCapitalLetter("aaAAaSAaaaaaaaaa"));
        assertNotEquals("should not be 4", 4, countCapitalLetter("aaAaaAaaAbbbbb"));
    }


    public int countCapitalLetter(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                count++;
            }
        }
        return count;
    }



    @Test
    public void shouldSumDigitsOfString() {
        assertEquals("should be 5", 5, sumDigitsOfString("as1w2d1kk1kk"));
        assertEquals("should be 7", 7, sumDigitsOfString("2as1w2d1kkkk1"));
        assertNotEquals("should not be 6", 6, sumDigitsOfString("123as1w2d1kkkk1"));

    }

    public int sumDigitsOfString(String s) {
        int result = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {

                result = result + Character.getNumericValue(c);
            }
        }
        return result;
    }


    @Test
    public void shouldReverseCaseOfString() {
        assertEquals("AAaa", reverseCase("aaAA"));
        assertEquals( "aAAaaA", reverseCase("AaaAAa"));
        assertEquals( " ", reverseCase(" "));
    }

    public String reverseCase(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(Character.toUpperCase(c));
            }
        }

        return sb.toString();
    }

    @Test
    public void shouldReverseCamelCaseToSnakeCase() {
        assertEquals("hello_world", camelCaseToSnakeCase("helloWorld"));
        assertEquals("_hello_world", camelCaseToSnakeCase("HelloWorld"));
    }


    public String camelCaseToSnakeCase(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                c = Character.toLowerCase(c);
                sb.append ("_");
            }

            sb.append(c);
        }

        return sb.toString();
    }

    @Test
    public void shouldReverseSnakeCaseToCamelCase() {
        assertEquals("helloWorld", snakeCaseToCamelCase("hello_world"));
        assertEquals("HelloWorld", snakeCaseToCamelCase("_hello_world"));
        assertEquals("HelloWorlD", snakeCaseToCamelCase("_hello_worl_d"));
        assertEquals("", snakeCaseToCamelCase("_____"));
    }

    public String snakeCaseToCamelCase(String s) {
        StringBuilder sb = new StringBuilder();

        boolean wasUnderscore = false;

        for (char c : s.toCharArray()) {
            if (c == '_') {
                wasUnderscore = true;
            } else {
                if (wasUnderscore) {
                    sb.append(Character.toUpperCase(c));
                    wasUnderscore = false;
                } else {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }


    @Test
    public void shouldCountNumberOfDigits() {
        assertEquals(5, findDigitAmount2(11111));
        assertEquals(1, findDigitAmount2(1));
        assertNotEquals(4, findDigitAmount2(0));
    }

    public int findDigitAmount(int n) {
        String s = Integer.toString(n);
        return s.length();
    }

    public int findDigitAmount2(int n) {
        int count = 0;
        while (n > 0) {
            n /= 10;
            count++;
        }

        return count;
    }


    @Test
    public void shouldReturnEvenOrOddValue() {
        assertEquals("odd", evenOrOddNumberOfFactors(1));
        assertEquals("even", evenOrOddNumberOfFactors(222222));
        assertNotEquals("odd", evenOrOddNumberOfFactors(99));
        assertNotEquals("even", evenOrOddNumberOfFactors(11111));
    }


    public String evenOrOddNumberOfFactors(int n) {
        String s = Integer.toString(n);
        String result = "";
        int length = s.length();
        if (length % 2 == 0) {
            result = "even";
        } else {
            result = "odd";
        }
        return result;
    }


    @Test
    public void shouldReturnIfXAndOHasTheSameNumber () {
        assertEquals(true, countXAndO("oxox"));
        assertEquals(true, countXAndO("xoxoxo"));
        assertEquals(false, countXAndO("xxooo"));
        assertEquals(true, countXAndO(""));
        assertEquals(true, countXAndO("ox"));
        assertEquals(false, countXAndO("ooxxx"));
    }

    public static boolean countXAndO(String s) {
        int countX = 0;
        int countO = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'o') {
                countO++;
            } else if (s.charAt(i) == 'x') {
                countX++;
            }
        }
        if (countO == countX) {
            return true;
        }
        return false;
    }



    @Test
    public void shouldSortAscendingArray () {
        int[] tab = {4, 3, 2, 1};
        tab = orderArray(tab);
        int[] ordered = {1, 2, 3, 4};
        Arrays.toString(ordered);
        int[] test = {4, 3, 2, 1};
        Arrays.toString(test);
        assertEquals(Arrays.toString(ordered), Arrays.toString(tab));
        assertNotEquals(Arrays.toString(test), Arrays.toString(tab));
    }

    public static int[] orderArray(int[] array) {
        int[] sortedArray = Arrays.stream(array).sorted().toArray();
        return sortedArray;
    }






}

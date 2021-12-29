package com.Foxminded.Devision;

import java.util.ArrayList;
import java.util.Collections;
import java.util.StringJoiner;

public class Devision {

    private static final String SPACE = " ";
    private static final String UNDERSCORE = "_";
    private static final String PIPE = "|";

    public static String spaceGenerator(int quantity) {

        StringJoiner stringJoiner = new StringJoiner("");
        for (int i = 0; i < quantity; i++) {
            stringJoiner.add(" ");
        }
        return stringJoiner.toString();
    }

    public static String dashGenerator(int quantity) {

        StringJoiner stringJoiner = new StringJoiner("");
        for (int i = 0; i < quantity; i++) {
            stringJoiner.add("-");
        }
        return stringJoiner.toString();
    }

    public static int sizeDifference(int i, int j) {

        int counter1 = 0;
        int counter2 = 0;
        while (i >= 1) {
            i = i / 10;
            counter1++;
        }
        while (j >= 1) {
            j = j / 10;
            counter2++;
        }
        return counter1 - counter2;
    }

    public static ArrayList<Integer> getDigitsOfDividend(int devident) {

        ArrayList<Integer> digitsOfDividend = new ArrayList<>();

        while (devident > 0) {
            digitsOfDividend.add(devident % 10);
            devident = devident / 10;
        }
        Collections.reverse(digitsOfDividend);
        return digitsOfDividend;
    }

    public static ArrayList<Step> division(ArrayList<Integer> digitsOfDivident, int devider) {

        ArrayList<Step> steps = new ArrayList<>();

        int quotient;
        int remainder = 0;
        Integer elementaryDevident = digitsOfDivident.get(0);
        boolean flag = false;

        for (Integer integer : digitsOfDivident) {

            if (flag) elementaryDevident = elementaryDevident * 10 + integer;
            else elementaryDevident = remainder * 10 + integer;

            if (elementaryDevident < devider) {
                flag = true;
            } else {

                quotient = elementaryDevident / devider;
                remainder = elementaryDevident % devider;
                steps.add(new Step(elementaryDevident, quotient * devider, remainder));
                flag = false;
            }
        }
        return steps;
    }

    public static void formatter(int dividend, int divider, ArrayList<Step> steps) {

        int quotient = dividend / divider;

        int firstSubtrahend = steps.get(0).subtrahend;
        int firstSubtrahendLength = steps.get(0).subtrahend;
        int quotientLength = sizeDifference(quotient, 0);


        // first string
        System.out.println(UNDERSCORE + dividend + PIPE + divider);

        // second string
        System.out.println(SPACE + firstSubtrahend + spaceGenerator(sizeDifference(dividend, firstSubtrahend)) + PIPE + dashGenerator(quotientLength));

        //third string
        System.out.println(SPACE + dashGenerator(firstSubtrahendLength) + spaceGenerator(sizeDifference(dividend, firstSubtrahend)) + PIPE + quotient);

        int spacesBefore = 1;

        for (int i = 1; i < steps.size(); i++) {

            int previousSubtrahend = steps.get(i - 1).subtrahend;
            int previousRemainder = steps.get(i - 1).remainder;

            int elementaryDevident = steps.get(i).elementaryDevident;
            int subtrahend = steps.get(i).subtrahend;
            int remainder = steps.get(i).remainder;

            int subtrahendLength = sizeDifference(steps.get(i).subtrahend, 0);

            spacesBefore = spacesBefore + sizeDifference(previousSubtrahend, previousRemainder) - 1;

            System.out.println(spaceGenerator(spacesBefore) + UNDERSCORE + elementaryDevident);

            spacesBefore = spacesBefore + sizeDifference(elementaryDevident, subtrahend) + 1;

            System.out.println(spaceGenerator(spacesBefore) + subtrahend);
            System.out.println(spaceGenerator(spacesBefore) + dashGenerator(subtrahendLength));

            if (i == steps.size() - 1)
                System.out.println(spaceGenerator(spacesBefore + sizeDifference(subtrahend, remainder)) + remainder);
        }
    }
}

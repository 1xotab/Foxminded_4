package com.Foxminded.Devision;

import java.util.ArrayList;

public class DevisionTest {
    public static void main(String[] args) {

        int devident=1234;
        int devider=100;

        ArrayList<Integer>arrayList =  Devision.getDigitsOfDividend(devident);
        Devision.division(arrayList,devider);
        Devision.formatter(devident,devider,Devision.division(arrayList,devider));
    }
}

package com.zhuravchak.epam.task1.numbers.perfectnumber;

import java.util.ArrayList;

/**
 * Created by Yaroslav on 28-Jul-17.
 */
public class Main {

    public static void main(String[] args) {

           PerfectNumber pn = new PerfectNumber();
           ArrayList<Integer> listOfNumbers = pn.findPerfectNumbers(pn.inputDiapason());
           System.out.println(listOfNumbers);
    }
}

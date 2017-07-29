package com.zhuravchak.epam.task1.numbers.perfectnumber;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Yaroslav on 22-Jul-17.
 */
public class PerfectNumber {

    public int inputDiapason() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the diapason of numbers (from 1):");
        int diapason = scanner.nextInt();

        if (diapason < 0) {
           throw new NumberFormatException("Not a positive number");
        }

        return diapason;
    }

    public ArrayList<Integer> findPerfectNumbers(int diapason){

        int sumOfDividers;
        ArrayList<Integer> perperfectNumbers = new ArrayList<>();

        for (int i = 1; i <= diapason; i++) {
            sumOfDividers = findSumOfDividers(i);
            if (sumOfDividers == i) {
                perperfectNumbers.add(sumOfDividers);
            }
        }
        return perperfectNumbers;
    }

    public int findSumOfDividers(int number){
        int sum = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum;
    }
}

package com.zhuravchak.epam.task1.task1_2;

import java.io.*;

/**
 * Created by Yaroslav on 22-Jul-17.
 */
public class PerfectNumbers {

    private int diapason;

    public PerfectNumbers() {
         defineDiapason();
    }

    public void defineDiapason() {
        System.out.println("Please enter the number of perfect numbers to output(from 1):");

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            diapason = Integer.valueOf(br.readLine());

            if (diapason < 0) {
               throw new NumberFormatException();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void findPerfectNumbers(){

        int perfectNumber;
        int counter = 0;

        for (int i = 1; i <= diapason; i++) {
            perfectNumber = findSumOfDividers(i);
            if (perfectNumber == i) {
                if (counter == 0) {
                    System.out.println("Perfect numbers:");
                }
                System.out.print(perfectNumber + " ");
                counter++;
            }
        }
        if (counter ==0 ) {
            System.out.println("There's no perfect numbers");
        }
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

    public static void main(String[] args) {
        try {
            PerfectNumbers perfectNumbers = new PerfectNumbers();
            perfectNumbers.findPerfectNumbers();
        } catch (NumberFormatException e){
            System.out.println("It's not a positive integer number");
        }
    }
}

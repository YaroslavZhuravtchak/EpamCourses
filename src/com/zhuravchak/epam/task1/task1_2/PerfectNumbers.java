/**
 * Created by Yaroslav on 22-Jul-17.
 */

package com.zhuravchak.epam.task1.task1_2;

import java.io.*;

public class PerfectNumbers {
    public PerfectNumbers(){
        defineNumber();
    }

    public void defineNumber(){
        System.out.println("Please enter the number of perfect numbers to output(from 1):");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int numberOfPerfectNumbers = Integer.valueOf(br.readLine());
            if (numberOfPerfectNumbers < 0) {
                System.out.println("It's not a positive number");
                return;
            }
            findAllPerfectNumbers(numberOfPerfectNumbers);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("It's not a integer number");
        }
    }

    public void findAllPerfectNumbers(int numberOfPerfectNumbers){
        int perfectNumber;
        System.out.println("Perfect numbers:");
        for (int i = 1; i <= numberOfPerfectNumbers; i++) {
            perfectNumber = findPerfectNumber(i);
            if (perfectNumber == i) {
                System.out.print(perfectNumber + " ");
            }
        }
    }

    public int findPerfectNumber(int number){
        int perfectNumber = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                perfectNumber += i;
            }
        }
        return perfectNumber;
    }

    public static void main(String[] args) {
        new PerfectNumbers();
    }
}

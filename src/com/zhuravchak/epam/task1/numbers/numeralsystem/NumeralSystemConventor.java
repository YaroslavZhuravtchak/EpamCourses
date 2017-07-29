package com.zhuravchak.epam.task1.numbers.numeralsystem;

import java.io.*;
import java.util.Scanner;

/**
 * Created by Yaroslav on 22-Jul-17.
 */
public class NumeralSystemConventor {


    public long inputNumber() throws NumberFormatException{
        long number;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter positive decimal integer number:");

            number = scanner.nextInt();

            if (number < 0) {
                throw new NumberFormatException("Bad number");
            }

            return number;
    }

    public String convert(long number, int base){
        StringBuilder newNumber = new StringBuilder();

        while(number>=base){
            newNumber.append(getDigit((int)number%base));
            number /= base;
        }
        newNumber.append(getDigit((int)number));
        return newNumber.reverse().toString();
    }

    public char getDigit(int number) throws NumberFormatException{
        char digit;

        switch (number) {
        case 0:
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
        case 7:
        case 8:
        case 9:
          digit=(char)(number+48);
          break;
        case 10:
          digit='a';
          break;
        case 11:
          digit='b';
          break;
        case 12:
          digit='c';
          break;
        case 13:
          digit='d';
          break;
        case 14:
          digit='e';
          break;
        case 15:
          digit='f';
          break;
        default:
          throw new NumberFormatException("Bad base!!!");
        }
        return digit;
    }
}

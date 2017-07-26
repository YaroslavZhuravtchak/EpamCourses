package com.zhuravchak.epam.task1.task1_1;

import java.io.*;

/**
 * Created by Yaroslav on 22-Jul-17.
 */
public class NumeralSystemConventor {

    private long number;

    public void enterNumber() throws NumberFormatException{
        System.out.println("Please enter positive decimal integer number:");
        try  {
            int digit;
            String str = "";

            while(true){
                digit = System.in.read();
                if (digit == (int) ('\n')) {
                    break;
                }
                str += (char)digit;
            }

            number = Long.parseLong(str);

            if (number < 0) {
                throw new NumberFormatException();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showConvertedNumbers(){
        System.out.println("Your number in the binary numeral system:");
        System.out.println(convert(number, 2));
        System.out.println("Your number in the octal numeral system:");
        System.out.println(convert(number, 8));
        System.out.println("Your number in the hexadecimal numeral system:");
        System.out.println(convert(number, 16));
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
          throw new NumberFormatException();
        }
        return digit;
    }

    public static void main(String[] args) {
         NumeralSystemConventor conventor = new NumeralSystemConventor();
         try {
             conventor.enterNumber();
             conventor.showConvertedNumbers();
         } catch (NumberFormatException e) {

         }

    }
}

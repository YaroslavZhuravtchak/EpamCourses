package com.zhuravchak.epam.task1.task1_1;

import java.io.*;

/**
 * Created by Yaroslav on 22-Jul-17.
 */
public class NumeralSystemConventor {

    public NumeralSystemConventor(){
        defineDecimalNumber();
    }

    public void defineDecimalNumber(){
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
            long number = Long.parseLong(str);
            if (number < 0) {
                System.out.println("It's not a positive number");
                return;
            }
            convertDecimalNumber(number);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
           System.out.println("It's not a integer number");
         }
    }

    public void convertDecimalNumber(long decimalNumber){
        System.out.println("Your number in the binary numeral system:");
        System.out.println(Long.toBinaryString(decimalNumber));
        System.out.println("Your number in the octal numeral system:");
        System.out.println(Long.toOctalString(decimalNumber));
        System.out.println("Your number in the hexadecimal numeral system:");
        System.out.println(Long.toHexString(decimalNumber));
    }

    public static void main(String[] args) {
         new NumeralSystemConventor();
    }
}

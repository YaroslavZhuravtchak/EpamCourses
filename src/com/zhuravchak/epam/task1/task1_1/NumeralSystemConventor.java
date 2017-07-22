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
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int number=Integer.valueOf(br.readLine());
            if(number<0){
                System.out.println("It's not a positive number");
                return;
            }
            convertDecimalNumber(number);
        }catch (IOException e){
            e.printStackTrace();
        }catch (NumberFormatException e){
            System.out.println("It's not a integer number");
        }
    }
    public void convertDecimalNumber(int decimalNumber){
        System.out.println("Your number in the binary numeral system:");
        System.out.println(Integer.toBinaryString(decimalNumber));
        System.out.println("Your number in the octal numeral system:");
        System.out.println(Integer.toOctalString(decimalNumber));
        System.out.println("Your number in the hexadecimal numeral system:");
        System.out.println(Integer.toHexString(decimalNumber));
    }
    public static void main(String[] args) {
         new NumeralSystemConventor();
    }
    }

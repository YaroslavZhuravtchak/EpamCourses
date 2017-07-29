package com.zhuravchak.epam.task1.numbers.numeralsystem;

/**
 * Created by Yaroslav on 28-Jul-17.
 */
public class Main {

    public static void main(String[] args) {

        NumeralSystemConventor conventor = new NumeralSystemConventor();

        long number = conventor.inputNumber();

        System.out.println("Your number in the binary numeral system:");
        System.out.println(conventor.convert(number, 2));
        System.out.println("Your number in the octal numeral system:");
        System.out.println(conventor.convert(number, 8));
        System.out.println("Your number in the hexadecimal numeral system:");
        System.out.println(conventor.convert(number, 16));


    }
}

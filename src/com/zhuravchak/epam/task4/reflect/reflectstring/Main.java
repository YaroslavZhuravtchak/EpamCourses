package com.zhuravchak.epam.task4.reflect.reflectstring;

import java.util.Scanner;

/**
 * Created by Yaroslav on 04-Aug-17.
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StringReflection sr = new StringReflection();

        System.out.println("Введіть строку:");
        String str = scanner.nextLine();

        System.out.println("Введіть нову строку:");
        String newStr = scanner.nextLine();

        System.out.println("\nCтрока до заміни:");
        System.out.println(str);
        sr.reflectString(str, newStr.toCharArray());

        System.out.println("\nСтрока після заміни:");
        System.out.println(str);
    }
}

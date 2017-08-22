package com.zhuravchak.epam.task5.task5_2;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

/**
 * Created by Yaroslav on 16-Aug-17.
 */
public class Main {
    public static void main(String[] args) {

        ForkJoinPool pool = new ForkJoinPool (8) ;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введіть директорію:");
        String path = sc.nextLine();
        File file = new File(path);

        while(!file.isDirectory()){
            System.out.println("Ви ввели неіснуючу директорію");
            System.out.println("Введіть директорію ще раз");
            path = sc.nextLine();
            file = new File(path);
        }

        Replacer summator = new Replacer(file);

        pool.invoke(summator);

    }
}

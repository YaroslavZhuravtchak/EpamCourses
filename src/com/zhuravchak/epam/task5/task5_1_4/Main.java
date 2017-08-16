package com.zhuravchak.epam.task5.task5_1_4;

import java.util.concurrent.ForkJoinPool;

/**
 * Created by Yaroslav on 16-Aug-17.
 */
public class Main {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool (8) ;
        int[] numbers = new int[1_000_000];

        for(int i = 0; i < numbers.length; i++){
            numbers[i] = (int)(Math.random()*100);
        }

        ArraySummator summator = new ArraySummator(numbers, 0, numbers.length);

        int sum = summator.invoke();

        System.out.println(sum);
    }
}

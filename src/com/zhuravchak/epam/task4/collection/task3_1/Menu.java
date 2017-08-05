package com.zhuravchak.epam.task4.collection.task3_1;

import com.zhuravchak.epam.task4.trains.file.TrainTableWriterAndReader;
import com.zhuravchak.epam.task4.trains.module.Train;
import com.zhuravchak.epam.task4.trains.module.TrainTable;

import java.awt.*;
import java.io.File;
import java.util.*;
import java.util.List;


/**
 * Created by Yaroslav on 04-Aug-17.
 */
public class Menu {

    List<Integer> list = new ArrayList<>();
    Set<Integer> set = new TreeSet<>();

    public static void showMenu(){
        System.out.println("________________________________________________________\n"+
                "Введіть:\n" +
                " L  для генерування колекції List\n" +
                " S  для генерування колекції Set\n" +
                " OL  для виводу колекції List\n" +
                " OS  для виводу колекції Set\n" +
                " AL  для додавання елемента в List\n" +
                " AS  для додавання елемента в Set\n" +
                " E  для виходу\n"+
                "________________________________________________________\n");
    }

    public  String getSrtingFromConsole(){
        Scanner in = new Scanner(System.in);
        String str = in.next();
        return str;
    }
    public  int getIntFromConsole(){
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        return number;
    }

    public void runMenu(){
        Scanner in = new Scanner(System.in);
        Generator generator = new Generator();

       while (true) {
           showMenu();
           String ch = getSrtingFromConsole();

           if (ch.equalsIgnoreCase("L")) {

               System.out.println("Введіть кількість елементів: ");
               int numberOfElements = getIntFromConsole();
               System.out.println("Введіть мінімальне значення: ");
               int minValue = getIntFromConsole();
               System.out.println("Введіть максимальне значення: ");
               int maxValue = getIntFromConsole();

               list.addAll( generator.generatelist(numberOfElements, minValue, maxValue));

           } else if (ch.equalsIgnoreCase("S")) {
               System.out.println("Введіть кількість елементів: ");
               int numberOfElements = getIntFromConsole();
               System.out.println("Введіть мінімальне значення: ");
               int minValue = getIntFromConsole();
               System.out.println("Введіть максимальне значення: ");
               int maxValue = getIntFromConsole();

               set.addAll( generator.generatelist(numberOfElements, minValue, maxValue));

           } else if (ch.equalsIgnoreCase("OL")) {
               System.out.println(list);
           } else if (ch.equalsIgnoreCase("OS")) {
               System.out.println(set);
           }  else if (ch.equalsIgnoreCase("AL")) {
               System.out.println("Введіть елемент");
               list.add(getIntFromConsole());
           } else if (ch.equalsIgnoreCase("AS")) {
               System.out.println("Введіть елемент");
               set.add(getIntFromConsole());
           }else if (ch.equalsIgnoreCase("E")) {
                break;
           }
       }
    }
}

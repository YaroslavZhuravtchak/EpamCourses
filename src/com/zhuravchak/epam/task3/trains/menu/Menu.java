package com.zhuravchak.epam.task3.trains.menu;

import com.zhuravchak.epam.task3.trains.module.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Yaroslav on 26-Jul-17.
 */
public class Menu {
    TrainTable table;
    public Menu(TrainTable table) {
        this.table = table;
    }

    public static void showMenu(){
        System.out.println("________________________________________________________\n"+
                "Введіть:\n" +
                " I  для виводу всіх поїздів відсортованих за ID\n" +
                " T  для виводу всіх поїздів відсортованих за часом\n" +
                " G  для виводу поїздів в яких є вільні загальні місця\n" +
                " F  для пошуку поїзда по місту і часу відправлення\n" +
                " E  для виходу\n"+
                "________________________________________________________\n");
    }

    public  String getSrtingFromConsole(){
        Scanner in = new Scanner(System.in);
        String str = in.next();
        return str;
    }

    public  void runMenu(){
        while (true) {
            showMenu();
            String ch = getSrtingFromConsole();
            if (ch.equals( "I")) {
                table.arrangeTrainsByID();
                System.out.println(Arrays.toString(table.getTrains()));
            }else if (ch.equals("T")) {
                table.arrangeTrainsByTime();
                System.out.println(Arrays.toString(table.getTrains()));
            } else if (ch.equals("G")) {
                System.out.println(table.findTrainsWithGeneralSeats());
            } else if (ch.equals("F")) {
                try {
                    System.out.println("Введіть місто:");
                    String sity = getSrtingFromConsole();

                    System.out.println("Введіть час відправлення в форматі гг:xx :");
                    String time = getSrtingFromConsole();

                    ArrayList<Train> trains = table.findTrainsByCityAndTime(sity, time);

                    if(trains.size()==0){
                        System.out.println("\nПоїздів не знайдено");
                    } else {
                        System.out.println("\n" + trains);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Невірний формат часу");
                }
            } else if (ch.equals("E")) {
                break;
            }
        }
    }

}

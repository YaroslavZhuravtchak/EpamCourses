package com.zhuravchak.epam.task1.train.menu;

import com.zhuravchak.epam.task1.train.module.Train;
import com.zhuravchak.epam.task1.train.module.TrainTable;

import java.lang.reflect.Array;
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
                " L  для виводу всіх поїздів\n" +
                " S  для виводу поїздів в яких є вільні загальні місц\n" +
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

            if (ch.equalsIgnoreCase( "L")) {

                table.arrangeTrainsByID();
                System.out.println(Arrays.toString(table.getTrains()));

            } else if (ch.equalsIgnoreCase("S")) {

                System.out.println(table.findTrainsWithGeneralSeats());

            } else if (ch.equalsIgnoreCase("F")) {

                try {
                    System.out.println("Введіть місто:");
                    String sity = getSrtingFromConsole();

                    System.out.println("Введіть час відправлення в форматі гг:xx :");
                    String time = getSrtingFromConsole();

                    ArrayList<Train> trains = table.findTrainsByCityAndTime(sity, time);

                    if(trains.size()==0){
                        System.out.println("Поїздів не знайдено");
                    } else {
                        System.out.println("\n"+trains);
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Невірний формат часу");
                }

            } else if (ch.equalsIgnoreCase("E")) {
                break;
            }
        }
    }

}

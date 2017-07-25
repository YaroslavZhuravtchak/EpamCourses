package com.zhuravchak.epam.task3;

import java.util.Scanner;

/**
 * Created by Yaroslav on 24-Jul-17.
 */
public class Main {

    public static String getSrtingFromConsole(){
        Scanner in = new Scanner(System.in);
        String str = in.next();
        return str;
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

    public static void main(String[] args) {

        TrainTable trainTable = new TrainTable();

        while (true) {
            showMenu();
            String ch = getSrtingFromConsole();
            if (ch.equals( "L")) {
                trainTable.arrangeTrains();
            } else if (ch.equals("S")) {
                trainTable.showListOvTrainWithGeneralSeats();
            } else if (ch.equals("F")) {
                try {
                    System.out.println("Введіть місто:");
                    String sity = getSrtingFromConsole();

                    System.out.println("Введіть час відправлення в форматі гг:xx :");

                    String time = getSrtingFromConsole();
                    trainTable.findTrains(sity, time);
                } catch (NumberFormatException e) {
                    System.out.println("Невірний формат часу");
                }
            } else if (ch.equals("E")) {
                break;
            }
        }
    }
}

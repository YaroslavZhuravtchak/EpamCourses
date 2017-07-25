package com.zhuravchak.epam.task3;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Yaroslav on 24-Jul-17.
 */
public class Main {

    public static String getSrtingfromConsole(){
        Scanner in = new Scanner(System.in);
        String sity = in.next();
        return sity;
    }
    public static void showMenu(){
        System.out.println("________________________________________________________\n"+
                "Введіть:\n" +
                " L  для виводу всіх поїздів;\n" +
                " S  для виводу поїздів в яких є вільні загальні місця;\n" +
                " F  для пошуку поїзда по місту і часу відправлення.\n" +
                " E  для виходу\n"+
                "________________________________________________________\n");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException {
        TrainTable trainTable = new TrainTable();

        while (true) {
            showMenu();
            String ch = getSrtingfromConsole();
            if (ch.equals( "L")) {
                trainTable.arrangeTrains();
            } else if (ch.equals("S")) {
                trainTable.showListOvTrainWithGeneralSeats();
            } else if (ch.equals("F")) {
                try {
                    System.out.println("Введіть місто:");
                    String sity = getSrtingfromConsole();

                    System.out.println("Введіть час відправлення в форматі гг:xx :");

                    String time = getSrtingfromConsole();
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

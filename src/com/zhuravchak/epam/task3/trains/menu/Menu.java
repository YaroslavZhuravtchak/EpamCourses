package com.zhuravchak.epam.task3.trains.menu;


import com.zhuravchak.epam.task3.trains.schedule.TrainTable;
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
            if (ch.equals( "L")) {
                table.arrangeTrains();
            } else if (ch.equals("S")) {
                table.showListOvTrainWithGeneralSeats();
            } else if (ch.equals("F")) {
                try {
                    System.out.println("Введіть місто:");
                    String sity = getSrtingFromConsole();

                    System.out.println("Введіть час відправлення в форматі гг:xx :");

                    String time = getSrtingFromConsole();
                    table.findTrains(sity, time);
                } catch (NumberFormatException e) {
                    System.out.println("Невірний формат часу");
                }
            } else if (ch.equals("E")) {
                break;
            }
        }
    }

}

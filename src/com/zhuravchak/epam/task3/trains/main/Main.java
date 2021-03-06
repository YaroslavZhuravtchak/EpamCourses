package com.zhuravchak.epam.task3.trains.main;

import com.zhuravchak.epam.task3.trains.menu.Menu;
import com.zhuravchak.epam.task3.trains.module.*;

/**
 * Created by Yaroslav on 24-Jul-17.
 */
public class Main {

    public static void main(String[] args) {

        Train[] trains = TrainGenerator.generateTrains();
        TrainTable table = new TrainTable(trains);
        Menu menu = new Menu(table);
        menu.runMenu();

    }
}

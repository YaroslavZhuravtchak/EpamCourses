package com.zhuravchak.epam.task4.trains.main;

import com.zhuravchak.epam.task4.trains.menu.Menu;
import com.zhuravchak.epam.task4.trains.module.Train;
import com.zhuravchak.epam.task4.trains.module.TrainGenerator;
import com.zhuravchak.epam.task4.trains.module.TrainTable;

import java.util.ArrayList;

/**
 * Created by Yaroslav on 24-Jul-17.
 */
public class Main {

    public static void main(String[] args) {
        TrainGenerator generator = new TrainGenerator();
        ArrayList<Train> trains = generator.generateTrains();
        TrainTable table = new TrainTable(trains);
        Menu menu = new Menu(table);
        menu.runMenu();

    }
}

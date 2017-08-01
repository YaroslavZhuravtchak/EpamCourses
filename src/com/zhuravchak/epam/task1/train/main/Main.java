package com.zhuravchak.epam.task1.train.main;

import com.zhuravchak.epam.task1.train.menu.Menu;
import com.zhuravchak.epam.task1.train.module.Train;
import com.zhuravchak.epam.task1.train.module.TrainGenerator;
import com.zhuravchak.epam.task1.train.module.TrainTable;

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

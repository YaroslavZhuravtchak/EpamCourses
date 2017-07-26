package com.zhuravchak.epam.task3.trains.app;

import com.zhuravchak.epam.task3.trains.menu.Menu;
import com.zhuravchak.epam.task3.trains.schedule.TrainTable;



/**
 * Created by Yaroslav on 24-Jul-17.
 */
public class App {

    public static void main(String[] args) {

        Menu menu = new Menu(new TrainTable());
        menu.runMenu();

    }
}

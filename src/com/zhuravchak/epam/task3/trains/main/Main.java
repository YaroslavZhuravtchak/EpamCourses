package com.zhuravchak.epam.task3.trains.main;

import com.zhuravchak.epam.task3.trains.menu.Menu;
import com.zhuravchak.epam.task3.trains.module.TrainTable;

/**
 * Created by Yaroslav on 24-Jul-17.
 */
public class Main {

    public static void main(String[] args) {

        Menu menu = new Menu(new TrainTable());
        menu.runMenu();

    }
}

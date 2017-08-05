package com.zhuravchak.epam.task4.dictionary.main;

import com.zhuravchak.epam.task4.dictionary.menu.Menu;
import com.zhuravchak.epam.task4.dictionary.module.Dictionary;

/**
 * Created by Yaroslav on 05-Aug-17.
 */
public class Main {

    public static void main(String[] args) {

        Dictionary dictionary = new Dictionary();
        dictionary.initDictionary();
        Menu menu = new Menu(dictionary);
        menu.runMenu();

    }
}

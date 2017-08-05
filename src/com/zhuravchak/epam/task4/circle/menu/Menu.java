package com.zhuravchak.epam.task4.circle.menu;

import com.zhuravchak.epam.task4.circle.module.CircleSet;

import java.util.*;

/**
 * Created by Yaroslav on 04-Aug-17.
 */
public class Menu {

    private CircleSet circleSet;

    public Menu() {
        circleSet = new CircleSet();
    }

    public static void showMenu(){
        System.out.println("________________________________________________________\n"+
                "Введіть:\n" +
                " A  для додавання нового круга в колекцію\n" +
                " F  для пошуку пересікань і перекривань кругів\n" +
                " E  для виходу\n"+
                "________________________________________________________\n");
    }

    public  double getDoubleFromConsole(){
        Scanner in = new Scanner(System.in);
        double number = in.nextDouble();
        return number;
    }

    public  String getSrtingFromConsole(){
        Scanner in = new Scanner(System.in);
        String str = in.next();
        return str;
    }

    public void runMenu(){

        while (true) {
            showMenu();
            String ch = getSrtingFromConsole();

            if (ch.equalsIgnoreCase("A")) {

                System.out.println("Ведіть координату х центру круга:");
                double x = getDoubleFromConsole();
                System.out.println("Ведіть координату у центру круга:");
                double y = getDoubleFromConsole();
                System.out.println("Ведіть радіус круга:");
                double r = getDoubleFromConsole();

                circleSet.addCircle(x,y,r);

            } else if (ch.equalsIgnoreCase("F")) {

                circleSet.findIntersectAndTouchedCircles();

            } else if (ch.equalsIgnoreCase("E")) {
                break;
            }
        }
    }
}

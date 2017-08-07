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
                while(r<0){
                    System.out.println("Pадіус круга не може бути відємним числом.");
                    System.out.println("Ведіть радіус круга ще раз:");
                    r = getDoubleFromConsole();
                }
                circleSet.addCircle(x,y,r);
                System.out.println("Круг додано в колекцію");

            } else if (ch.equalsIgnoreCase("F")) {
                if(circleSet.getCircles().size()<2){
                     System.out.println("В колекції недостатньо кругів для порівняння");
                } else {
                    circleSet.findIntersectAndTouchedCircles();
                    if (circleSet.getIntersectedCircles().size() == 0 && circleSet.getTouchedCircles().size() == 0) {
                        System.out.println("Жодні круги не пересікаються і не дотикаються");
                    } else{
                        if (circleSet.getIntersectedCircles().size() > 0) {
                            System.out.println("\nКруги які пересікаються:");
                            System.out.println(circleSet.getIntersectedCircles());
                        }
                        if (circleSet.getTouchedCircles().size() > 0) {
                            System.out.println("\nКруги які дотикаються:");
                            System.out.println(circleSet.getTouchedCircles());
                        }
                    }
                }
            } else if (ch.equalsIgnoreCase("E")) {
                break;
            }
        }
    }
}

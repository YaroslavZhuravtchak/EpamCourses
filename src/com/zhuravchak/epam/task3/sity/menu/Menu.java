package com.zhuravchak.epam.task3.sity.menu;

import com.zhuravchak.epam.task3.sity.module.*;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Yaroslav on 31-Jul-17.
 */
public class Menu {
    City city;
    Scanner scanner = new Scanner(System.in);

    public static void showMenu() {

        System.out.println("________________________________________________________\n" +
                "Введіть:\n" +
                " В  для додавання нової вулиці\n" +
                " С  для показу всієї інформації про вулиці \n" +
                " Д  для виводу загальної довжини всіх вулиць міста \n" +
                " Б  для виводу кількості всіх будинків міста \n" +
                " Е  для виходу\n" +
                "________________________________________________________\n");
    }

    public  String getSrtingFromConsole(){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        return str;
    }

    public void runMenu() {

        System.out.println("Введіть назву міста:");
        String nameOfCity = getSrtingFromConsole();
        if(nameOfCity.equals("")){
            System.out.println("Ви не ввели назву міста");
            return;
        }
        nameOfCity = Character.toUpperCase(nameOfCity.charAt(0))+nameOfCity.substring(1);
        city = new City(nameOfCity);

        while (true) {

            showMenu();
            String ch = scanner.next();

            if (ch.equalsIgnoreCase("В")) {

                String nameOfStreet;
                int numberOfBuildings;
                int lengthOfStreet;
                int zip;

                try {
                    System.out.println("Введіть назву вулиці:");
                    nameOfStreet = getSrtingFromConsole();
                    if(nameOfStreet.equals("")){
                        System.out.println("Ви не ввели назву вулиці");
                        continue;
                    }
                    nameOfStreet = Character.toUpperCase(nameOfStreet.charAt(0)) + nameOfStreet.substring(1);

                    System.out.println("Введіть довжину вулиці у метрах:");
                    lengthOfStreet = scanner.nextInt();
                    if (lengthOfStreet < 0) {
                        System.out.println("Невірний формат довжини");
                        System.out.println("Вулицю не додано");
                        continue;
                    }

                    System.out.println("Введіть кількість будинків:");
                    numberOfBuildings = scanner.nextInt();
                    if (numberOfBuildings < 0) {
                        System.out.println("Відємна кількість будинків");
                        System.out.println("Вулицю не додано");
                        continue;
                    }

                    System.out.println("Введіть поштовий індекс (пятизначне число):");
                    zip = scanner.nextInt();
                    if (zip < 1000 || zip > 99999) {
                        System.out.println("Невірний формат поштового індексу");
                        System.out.println("Вулицю не додано");
                        continue;
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Невірний формат!");
                    System.out.println("Вулицю не додано");
                    continue;
                }

                city.addStreet(nameOfStreet, numberOfBuildings, lengthOfStreet, zip);

            } else if (ch.equalsIgnoreCase("С")) {
                city.showAllSteets();
            } else if (ch.equalsIgnoreCase("Д")) {
                System.out.printf("Довжина всіх вулиць міста %s складає %d м.\n", city.getNameOfCity(),
                                city.calculatelengthOfAllStreets());
            } else if (ch.equalsIgnoreCase("Б") ){
            System.out.printf("У місті %s %d будинків.\n", city.getNameOfCity(), city.calculatenumberOfAllBuildings());
            } else if (ch.equalsIgnoreCase("Е")) {
            break;
            }
        }
    }
}


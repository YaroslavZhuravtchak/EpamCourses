package com.zhuravchak.epam.task4.reflect.reflectobject;

/**
 * Created by Yaroslav on 04-Aug-17.
 */
public class Main {
    public static void main(String[] args) {

        ObjectChanger objectChanger = new ObjectChanger();

        Car car = objectChanger.createInstance(800, 400, 70000);

        System.out.println("\nСтан обєкта:");
        System.out.println(car);

        System.out.println("\nМетоди обєкта:");
        objectChanger.showMethods(car);

        objectChanger.setPrice(car, 100000);

        System.out.println("\nНовий стан обєкта:");
        System.out.println(car);
    }
}

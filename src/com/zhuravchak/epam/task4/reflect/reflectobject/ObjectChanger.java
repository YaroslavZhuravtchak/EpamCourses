package com.zhuravchak.epam.task4.reflect.reflectobject;

import java.lang.reflect.*;

/**
 * Created by Yaroslav on 04-Aug-17.
 */
public class ObjectChanger {

    public Car createInstance(double weight, float maxSpeed, int price){
        Car car = null;

        try {
            Class carClass = Class.forName("com.zhuravchak.epam.task4.reflect.reflectobject.Car");

            Class<?>[] params = new Class<?>[] {double.class, float.class, int.class };

            Constructor<?> constructor = carClass.getConstructor(params);
            car = (Car)constructor.newInstance(weight, maxSpeed, price);

        } catch (ClassNotFoundException|IllegalAccessException|InstantiationException|
                InvocationTargetException|NoSuchMethodException e) {
            e.printStackTrace();
        }

        return car;
    }

    public void showMethods(Car car){

        Class carClass = car.getClass();
        Method[] methods = carClass.getDeclaredMethods();

        for (Method method : methods) {
            System.out.println("Name: " + method.getName());
            System.out.println("\tReturn type: "
                    + method.getReturnType().getName());
            Parameter[] parameters = method.getParameters();
            if(parameters.length!=0) {
                for (Parameter parameter : parameters) {
                    System.out.print("\tParameters: " + parameter.getParameterizedType().getTypeName() + " ");
                }
                System.out.println();
            }
        }
    }

    public void setPrice(Car car, int price){
        Class carClass = car.getClass();
        Class<?>[] params = new Class<?>[] { int.class };
        try {
            Method method = carClass.getMethod("setPrice", params);
            method.invoke(car, price);

        } catch (NoSuchMethodException|InvocationTargetException|IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

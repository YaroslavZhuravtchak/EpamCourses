package com.zhuravchak.epam.task4.reflect.reflectobject;

/**
 * Created by Yaroslav on 04-Aug-17.
 */
public class Car {

    public double weight = 700.5;
    protected float maxSpeed = 350;
    private int price = 50000;

    public  Car (){}

    public Car(double weight, float maxSpeed, int price) {
        this.weight = weight;
        this.maxSpeed = maxSpeed;
        this.price = price;
    }

    public Car(double weight, float maxSpeed) {
        this.weight = weight;
        this.maxSpeed = maxSpeed;
    }

    public double getWeight() {
        return weight;
    }

    public float getMaxSpeed() {
        return maxSpeed;
    }

    public int getPrice() {
        return price;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setMaxSpeed(float maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String toString(){
        return "weight = " + weight + ", maxSpeed = " + maxSpeed + " price = " + price +"\n";
    }
}

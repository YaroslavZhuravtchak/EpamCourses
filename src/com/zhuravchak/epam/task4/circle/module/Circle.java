package com.zhuravchak.epam.task4.circle.module;

/**
 * Created by Yaroslav on 05-Aug-17.
 */
public class Circle {
   private double x;
   private double y;
   private double r;

    public Circle(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return r;
    }

    @Override
    public String toString() {
        return "(x=" + x + " y=" + y +" r=" + r +")" ;
    }
}

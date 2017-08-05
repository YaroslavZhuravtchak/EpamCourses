package com.zhuravchak.epam.task4.circle.module;

//import javafx.scene.shape.Circle;

import java.util.*;

/**
 * Created by Yaroslav on 05-Aug-17.
 */
public class CircleSet {

    public Set<Circle> circles = new HashSet<>();

    public void addCircle(double x, double y, double r){
        circles.add(new Circle(x,y,r));
    }

    public void findIntersectAndTouchedCircles() {
        boolean isTouch = false;
        if(circles.size()<2){
            System.out.println("В колекції недостатньо кругів для порівняння");
        } else {
            Set<Circle> copyOfCircles = new HashSet<>(circles);
            Iterator<Circle> iterator = circles.iterator();
            for (Circle circle : circles) {
                copyOfCircles.remove(circle);
                for (Circle copyOfCircle : copyOfCircles) {
                    if(compareCircles(circle, copyOfCircle)){
                        isTouch = true;
                    }
                }
            }
            if(!isTouch){
                System.out.println("Жодні круги не пересікаються і не дотикаються");
            }
        }

    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public boolean compareCircles(Circle c1, Circle c2){
        boolean flug = false;
              if (c1.getR()+c2.getR() > calculateDistanceBetweenCenters(c1,c2)) {
                  System.out.printf("Круг(x=%f, y=%f, r=%f) пересікається з кругом (x=%f, y=%f, r=%f)\n",
                                c1.getX(), c1.getY(), c1.getR(), c2.getX(), c2.getY(), c2.getR());
                  flug = true;
              } else if (Math.abs((c1.getR()+c2.getR()) - calculateDistanceBetweenCenters(c1,c2))>1e-5){
                  System.out.printf("Круг(x=%f, y=%f, r=%f) дотикається з кругом (x=%f, y=%f, r=%f)\n",
                          c1.getX(), c1.getY(), c1.getR(), c2.getX(), c2.getY(), c2.getR());
                  flug = true;
              }
              return flug;
    }
     public double calculateDistanceBetweenCenters(Circle c1, Circle c2){

        return Math.sqrt(Math.pow(c1.getX() - c2.getX(),2) + Math.pow(c1.getY() - c2.getY(),2));

     }
}


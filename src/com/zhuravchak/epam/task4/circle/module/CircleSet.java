package com.zhuravchak.epam.task4.circle.module;

import java.util.*;

/**
 * Created by Yaroslav on 05-Aug-17.
 */
public class CircleSet {

    private Set<Circle> circles = new HashSet<>();
    private Map<Circle, Circle> intersectedCircles = new HashMap();
    private Map<Circle, Circle> touchedCircles = new HashMap<>();

    public void addCircle(double x, double y, double r){
        circles.add(new Circle(x,y,r));
    }

    public void findIntersectAndTouchedCircles() {

            Set<Circle> copyOfCircles = new HashSet<>(circles);

            for (Circle circle : circles) {
                copyOfCircles.remove(circle);
                for (Circle copyOfCircle : copyOfCircles) {
                    compareCircles(circle, copyOfCircle);
                }
            }


    }

    public void compareCircles(Circle c1, Circle c2){

        if (Math.abs((c1.getR()+c2.getR()) - calculateDistanceBetweenCenters(c1,c2)) < 0.00001) {
            touchedCircles.put(c1, c2);
        }
        else if (c1.getR()+c2.getR() > calculateDistanceBetweenCenters(c1,c2)) {
            intersectedCircles.put(c1, c2);
        }
    }

     public double calculateDistanceBetweenCenters(Circle c1, Circle c2){

        return Math.sqrt(Math.pow(c1.getX() - c2.getX(),2) + Math.pow(c1.getY() - c2.getY(),2));

     }

    public Set<Circle> getCircles() {
        return circles;
    }

    public Map<Circle, Circle> getIntersectedCircles() {
        return intersectedCircles;
    }

    public Map<Circle, Circle> getTouchedCircles() {
        return touchedCircles;
    }
}


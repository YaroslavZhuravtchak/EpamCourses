package com.zhuravchak.epam.task3.sity;

import java.util.*;

/**
 * Created by Yaroslav on 28-Jul-17.
 */
public class City {

    private String nameOfCity;
    private ArrayList<Street> elements;

    public String getNameOfCity() {
        return nameOfCity;
    }

    public ArrayList<Street> getElements() {
        return elements;
    }

    public City(String nameOfCity){
           this.nameOfCity = nameOfCity;
           elements =  new ArrayList<>();
    }

    public  void addStreet(String nameOfStreet, int numberOfBuildings, int lengthOfStreet ,int zip){
         elements.add(new Street(nameOfStreet,  numberOfBuildings, lengthOfStreet , zip));
    }

    public void showAllSteets(){

            Collections.sort(elements, new Comparator<Street>() {
                @Override
                public int compare(Street o1, Street o2) {
                  return o1.nameOfStreet.compareTo(o2.nameOfStreet);
                }
            });
        System.out.println("Назва вулиці       Довжина,м    К-ть будинків      Індекс");
            for(Street s: elements )   {
            System.out.printf("%-20s %-13d %-16d %05d",s.nameOfStreet, s.lengthOfStreet, s.numberOfBuildings, s.zip);
            System.out.println();
        }
    }
    public int calculatelengthOfAllStreets(){
        int sum = 0;
        for(Street s: elements){
            sum += s.lengthOfStreet;
        }
        return sum;
    }

    public int calculatenumberOfAllBuildings(){
        int sum = 0;
        for(Street s: elements){
            sum += s.numberOfBuildings;
        }
        return sum;
    }

    public class Street{

        private String nameOfStreet;
        private int numberOfBuildings;
        private int zip;
        private int lengthOfStreet;

        private Street(String nameOfStreet, int numberOfBuildings, int lengthOfStreet ,int zip){
              this.nameOfStreet = nameOfStreet;
              this.numberOfBuildings = numberOfBuildings;
              this.lengthOfStreet = lengthOfStreet;
              this.zip = zip;
        }

        public String getNameOfStreet() {
            return nameOfStreet;
        }

        public int getNumberOfBuildings() {
            return numberOfBuildings;
        }

        public int getZip() {
            return zip;
        }

        public int getLengthOfStreet() {
            return lengthOfStreet;
        }
    }
}

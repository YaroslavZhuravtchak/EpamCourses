package com.zhuravchak.epam.task1.train.module;

import com.zhuravchak.epam.task1.train.time.TimeConventor;

/**
 * Created by Yaroslav on 24-Jul-17.
 */
public class Train {

    private String finalDestination;
    private String timeOfLeaving;
    private int ID;
    private int numberOfGeneralSeats;
    private int numberOfReservedSeats;
    private int numberOfCoupeSeats;
    private int numberOfSVSeats;

    public Train(String finalDestination, String timeOfLeaving, int ID, int numberOfGeneralSeats,
             int numberOfReservedSeats, int numberOfCoupeSeats, int numberOfSVSeats){

        this.finalDestination = finalDestination;
        this.timeOfLeaving = timeOfLeaving;
        this.ID = ID;
        this.numberOfGeneralSeats = numberOfGeneralSeats;
        this.numberOfReservedSeats = numberOfReservedSeats;
        this.numberOfCoupeSeats = numberOfCoupeSeats;
        this.numberOfSVSeats = numberOfSVSeats;
    }

    public String toString(){
        return  "Номер поїзда:                 " + ID + "\n" +
                "Пункт призначення:            " + finalDestination + "\n" +
                "Час відправлення:             " + timeOfLeaving + "\n" +
                "Кількість загальних місць:    " + numberOfGeneralSeats + "\n" +
                "Кількість плацкартних місць:  " + numberOfReservedSeats + "\n" +
                "Кількість купейних місць:     " + numberOfCoupeSeats + "\n" +
                "Кількість СВ місць:           " + numberOfSVSeats + "\n\n" ;
    }

    public int getID() {
        return ID;
    }

    public String getFinalDestination() {
        return finalDestination;
    }

    public int getNumberOfGeneralSeats() {
        return numberOfGeneralSeats;
    }

    public String getTimeOfLeaving() {
        return timeOfLeaving;
    }
}

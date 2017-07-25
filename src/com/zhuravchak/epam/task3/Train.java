package com.zhuravchak.epam.task3;

/**
 * Created by Yaroslav on 24-Jul-17.
 */
public class Train {

    private String finalDestination;
    private int timeInMinute;
    private String timeOfLeaving;
    private int ID;
    private int numberOfGeneralSeats;
    private int numberOfReservedSeats;
    private int numberOfCoupeSeats;
    private int numberOfSVSeats;

    public Train(String finalDestination, String timeOfLeaving, int ID, int numberOfGeneralSeats,
             int numberOfReservedSeats, int numberOfCoupeSeats, int numberOfSVSeats){

        this.finalDestination = finalDestination;
        this.timeOfLeaving=timeOfLeaving;
        timeInMinute=getTimeInMinute(timeOfLeaving);
        this.ID=ID;
        this.numberOfGeneralSeats=numberOfGeneralSeats;
        this.numberOfReservedSeats=numberOfReservedSeats;
        this.numberOfCoupeSeats=numberOfCoupeSeats;
        this.numberOfSVSeats = numberOfSVSeats;
    }

   public static int getTimeInMinute(String timeOfLeaving){
       String[] time= timeOfLeaving.split(":");

        return Integer.valueOf(time[0])*60+Integer.valueOf(time[1]);
   }

    public String getFinalDestination() {
        return finalDestination;
    }

    public int getTimeInMinute() {
        return timeInMinute;
    }

    public String getTimeOfLeaving() {
        return timeOfLeaving;
    }

    public int getID() {
        return ID;
    }

    public int getNumberOfGeneralSeats() {
        return numberOfGeneralSeats;
    }

    public int getNumberOfReservedSeats() {
        return numberOfReservedSeats;
    }

    public int getNumberOfCoupeSeats() {
        return numberOfCoupeSeats;
    }

    public int getNumberOfSVSeats() {
        return numberOfSVSeats;
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
}

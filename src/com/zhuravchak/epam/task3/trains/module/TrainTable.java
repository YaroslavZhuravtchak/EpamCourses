package com.zhuravchak.epam.task3.trains.module;

import com.zhuravchak.epam.task3.trains.time.TimeConventor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Yaroslav on 24-Jul-17.
 */
public class TrainTable {

    Train[] trains ;

    public TrainTable(){
            this.trains = TrainGenerator.generateTrains();
    }

    public void showAllTrains(){
        System.out.println(Arrays.toString(trains));
    }

    public ArrayList<Train> showListOvTrainWithGeneralSeats(){

       ArrayList<Train> trainsWithGeneralSeats = new ArrayList<>();

       for (int i=0; i < trains.length; i++) {
           if (trains[i].getNumberOfGeneralSeats()>0) {
               trainsWithGeneralSeats.add(trains[i]);
           }
       }
       return trainsWithGeneralSeats;
    }

    public void arrangeTrainsByID(){
        Arrays.sort(trains, new Comparator<Train>(){
            @Override
            public int compare(Train t1, Train t2) {

                if (t1.getID() > t2.getID()) {
                    return  1;
                } else if (t1.getID() < t2.getID()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
    }

    public void arrangeTrainsByTime(){
        Arrays.sort(trains,  new Comparator<Train>(){
            @Override
            public int compare(Train t1, Train t2) {

                if (TimeConventor.toMinute(t1.getTimeOfLeaving())> TimeConventor.toMinute(t2.getTimeOfLeaving())) {
                    return  1;
                } else if (TimeConventor.toMinute(t1.getTimeOfLeaving())< TimeConventor.toMinute(t2.getTimeOfLeaving())) {
                    return -1;
                }
                    return 0;
            }
        });

        for (int i = 0; i < trains.length; i++){
            System.out.println(trains[i]);
        }
    }

    public  ArrayList<Train> findTrains(String sity, String time){

        ArrayList<Train> neededTrains = new ArrayList<>();

        for (int i = 0; i < trains.length; i++) {
            int timeLine = TimeConventor.toMinute(time);

            if (sity.equalsIgnoreCase(trains[i].getFinalDestination()) &&
                                    (TimeConventor.toMinute(trains[i].getTimeOfLeaving()) >= timeLine)) {
                neededTrains.add(trains[i]);
            }
        }
        return neededTrains;
    }
}


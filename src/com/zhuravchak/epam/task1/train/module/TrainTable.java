package com.zhuravchak.epam.task1.train.module;

import com.zhuravchak.epam.task1.train.comparator.TrainIDComparator;
import com.zhuravchak.epam.task1.train.time.TimeConventor;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Yaroslav on 24-Jul-17.
 */
public class TrainTable {

    Train[] trains ;

    public TrainTable(){
            this.trains = TrainGenerator.generateTrains();
    }

    public void showAllTrains(){
        System.out.println(trains);
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
        Arrays.sort(trains, new TrainIDComparator());
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


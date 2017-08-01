package com.zhuravchak.epam.task3.trains.module;

import com.zhuravchak.epam.task3.trains.time.TimeConventor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Yaroslav on 24-Jul-17.
 */
public class TrainTable {

    private Train[] trains ;

    public TrainTable(Train[] trains){
        this.trains = trains;
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
    }

    public ArrayList<Train> findTrainsWithGeneralSeats(){
        ArrayList<Train> trainsWithGeneralSeats = new ArrayList<>();
        for (int i=0; i < trains.length; i++) {
            if (trains[i].getNumberOfGeneralSeats()>0) {
                trainsWithGeneralSeats.add(trains[i]);
            }
        }
        return trainsWithGeneralSeats;
    }

    public  ArrayList<Train> findTrainsByCityAndTime(String city, String time){
        ArrayList<Train> neededTrains = new ArrayList<>();

        for (int i = 0; i < trains.length; i++) {
            int timeLine = TimeConventor.toMinute(time);

            if (city.equalsIgnoreCase(trains[i].getFinalDestination()) &&
                                    (TimeConventor.toMinute(trains[i].getTimeOfLeaving()) >= timeLine)) {
                neededTrains.add(trains[i]);
            }
        }
        return neededTrains;
    }

    public Train[] getTrains() {
        return trains;
    }
}


package com.zhuravchak.epam.task1.train.module;

import com.zhuravchak.epam.task1.train.comparator.TrainIDComparator;
import com.zhuravchak.epam.task1.train.time.TimeConventor;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Yaroslav on 24-Jul-17.
 */
public class TrainTable {

    private Train[] trains ;

    public TrainTable(Train[] trains){
            this.trains = trains;
    }

    public void arrangeTrainsByID(){
        Arrays.sort(trains, new TrainIDComparator());
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
        int timeLine = TimeConventor.toMinute(time);
        
        for (int i = 0; i < trains.length; i++) {
            
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


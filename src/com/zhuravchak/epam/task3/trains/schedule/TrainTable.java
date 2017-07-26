package com.zhuravchak.epam.task3.trains.schedule;

import com.zhuravchak.epam.task3.trains.comparator.TrainIDComparator;
import com.zhuravchak.epam.task3.trains.generator.TrainGenerator;
import com.zhuravchak.epam.task3.trains.train.Train;

import java.util.Arrays;

/**
 * Created by Yaroslav on 24-Jul-17.
 */
public class TrainTable {

    Train[] trains ;

    public TrainTable(){
            this.trains = TrainGenerator.generateTrains();
    }

    public void showListOvTrainWithGeneralSeats(){

       for (int i=0; i < trains.length; i++) {
           if (trains[i].getNumberOfGeneralSeats()>0) {
               System.out.println(trains[i]);
           }
       }
    }

    public void arrangeTrains(){
        Arrays.sort(trains, new TrainIDComparator());
        for (int i = 0; i < trains.length; i++){
                System.out.println(trains[i]);
            }
    }

    public void findTrains(String sity, String time){
        int counter = 0;
        System.out.println();

        for (int i = 0; i < trains.length; i++) {
            int timeLine = Train.getTimeInMinute(time);
            if (sity.equalsIgnoreCase(trains[i].getFinalDestination()) && (trains[i].getTimeInMinute() >= timeLine)) {
                counter++;
                System.out.println(trains[i]);
            }
        }
        if(counter == 0){
            System.out.println("Нажаль поїздів з даними параметрами немає\n");
        }
    }
}


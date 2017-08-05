package com.zhuravchak.epam.task4.trains.file;


import com.zhuravchak.epam.task1.train.module.*;
import com.zhuravchak.epam.task4.trains.module.*;
import com.zhuravchak.epam.task4.trains.module.Train;
import com.zhuravchak.epam.task4.trains.module.TrainTable;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Yaroslav on 04-Aug-17.
 */
public class TrainTableWriterAndReader {

    public static ArrayList<Train> readTrainTable(File file){
        ArrayList<Train> trains = null;

        try (ObjectInputStream oo = new ObjectInputStream(new FileInputStream(file))) {
            trains = new ArrayList<>();
            while (true) {
                try {
                    trains.add((Train) oo.readObject());
                } catch (EOFException e) {
                    break;
                }
            }
            return trains;
        } catch (IOException e){
            System.out.println("Невдалось прочитати обєкт");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return trains;
    }

    public static int writeTrainTable(File file, TrainTable table){

        try (ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(file))) {

            ArrayList<Train> trains = table.getTrains();
           for(Train train : trains) {
               oo.writeObject(train);
           }
            return 0;
        } catch (IOException e){
            System.out.println("Невдалось записати обєкти");;
        }
        return -1;
    }
}
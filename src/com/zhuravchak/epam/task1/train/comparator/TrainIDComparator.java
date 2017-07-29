package com.zhuravchak.epam.task1.train.comparator;

import com.zhuravchak.epam.task1.train.module.Train;

import java.util.Comparator;

/**
 * Created by Yaroslav on 24-Jul-17.
 */
public class TrainIDComparator implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {

        Train train1 = (Train) o1;
        Train train2 = (Train) o2;

        if (train1.getID() > train2.getID()) {
            return  1;
        } else if (train1.getID() < train2.getID()) {
            return -1;
        } else {
            return 0;
        }
    }
}

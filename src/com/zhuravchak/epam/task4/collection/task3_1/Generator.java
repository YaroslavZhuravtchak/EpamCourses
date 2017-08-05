package com.zhuravchak.epam.task4.collection.task3_1;

import java.util.*;

/**
 * Created by Yaroslav on 04-Aug-17.
 */
public class Generator {

    public List generatelist(int numberOfElements, int minValue, int maxValue ){
        List<Integer> list = new ArrayList();
        Random random = new Random();
        while (list.size() < numberOfElements){
            list.add(random.nextInt(maxValue - minValue)+minValue);
        }
        return list;
    }

    public Set generateSet(int numberOfElements, int minValue, int maxValue ){
        Set<Integer> set = new TreeSet<>();

        Random random = new Random();
        while (set.size() < numberOfElements){
            set.add(random.nextInt(maxValue - minValue)+minValue);
        }
        return set;
    }
}

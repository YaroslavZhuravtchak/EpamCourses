package com.zhuravchak.epam.task5.task5_1_3;

import java.util.*;

/**
 * Created by Yaroslav on 15-Aug-17.
 */
public class Writer implements Runnable {
    public Thread t;
    Map target ;
    int min;
    int max;
    String name;
    public Writer(Map target, String name,  int min, int max){
        this.target = target;
        this.min = min;
        this.max = max;
        this.name = name;
         t =  new Thread(this);
         t.start();
    }

    @Override
    public void run() {
        synchronized (target){

            for (int i = min; i < max; i++) {
                target.put(i, name );
              //  System.out.println("w "+name+" "+i);
            }

        }
    }
}

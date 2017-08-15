package com.zhuravchak.epam.task5.task5_1_3;

import java.util.*;

/**
 * Created by Yaroslav on 15-Aug-17.
 */
public class Reader implements Runnable {
    public Thread t;
    Map target ;
    int min;
    int max;

    public Reader(Map target,  int min, int max){
        this.target = target;
        this.min = min;
        this.max = max;
        t =  new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        synchronized (target){
            for (int i = min; i < max; i++) {
                while (target.get(i)==null)
                    try {
                        target.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                target.notify();
                target.get(i);
               // System.out.println("r "+target.get(i)+" " +i);

            }
            target.notify();
        }
    }
}

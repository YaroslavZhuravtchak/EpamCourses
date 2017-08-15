package com.zhuravchak.epam.task5.task5_1_3;

import java.util.Map;

/**
 * Created by Yaroslav on 16-Aug-17.
 */
public class CReader implements Runnable {
    public Thread t;
    Map target ;
    int min;
    int max;

    public CReader(Map target,  int min, int max){
        this.target = target;
        this.min = min;
        this.max = max;
        t =  new Thread(this);
        t.start();
    }

    @Override
    public void run() {

            for (int i = min; i < max; i++) {
                while (target.get(i)==null){};
                target.get(i);
                //System.out.println("r "+target.get(i)+" " +i);
            }
    }

}


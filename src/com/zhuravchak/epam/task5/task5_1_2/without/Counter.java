package com.zhuravchak.epam.task5.task5_1_2.without;

/**
 * Created by Yaroslav on 15-Aug-17.
 */
public class Counter implements Runnable {
    Value v;
    Thread t;
    public Counter(Value v) {
        this.v = v;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        while (v.i < 1000000) {
            v.i++;
        }
    }
}

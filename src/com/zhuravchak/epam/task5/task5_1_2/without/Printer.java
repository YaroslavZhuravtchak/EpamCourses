package com.zhuravchak.epam.task5.task5_1_2.without;

/**
 * Created by Yaroslav on 15-Aug-17.
 */
public class Printer implements Runnable{
    Value v;
    Thread t;
    public Printer(Value v) {
        this.v = v;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        while (v.i < 1000000) {
                System.out.println(v.i);
        }
    }
}

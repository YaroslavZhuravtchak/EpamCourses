package com.zhuravchak.epam.task5.task5_1_2.withsynchr;

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
        synchronized (v) {
            while (v.i < 1000000) {
                v.notify();
                System.out.println(v.i);
                try {
                    v.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            v.notify();
        }
    }
}

package com.zhuravchak.epam.task5.task5_1_2.withsynchr;

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
        synchronized (v) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (v.i < 1000000) {
                    v.notify();
                    try {
                        v.i++;
                        v.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
        }
    }
}

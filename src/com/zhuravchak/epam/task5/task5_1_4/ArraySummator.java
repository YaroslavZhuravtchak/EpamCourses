package com.zhuravchak.epam.task5.task5_1_4;

import java.util.concurrent.RecursiveTask;

/**
 * Created by Yaroslav on 16-Aug-17.
 */
public class ArraySummator extends RecursiveTask<Integer>{

    final int seqThresHold = 20 ;
    int start , end;
    int[] data;

    public ArraySummator(int[] data, int start, int end) {
        this.start = start;
        this.end = end;
        this.data = data;
    }

    @Override
    protected Integer compute() {
        int sum = 0;

        if ((end - start) < seqThresHold) {
            for (int i = start; i < end; i++) {
                sum += data[i];
            }
        } else {

            int middle = (start + end) / 2;

            ArraySummator subTaskA = new ArraySummator(data, start, middle);
            ArraySummator subTaskB = new ArraySummator(data, middle, end);

            subTaskA.fork();
            subTaskB.fork();

            sum = subTaskA.join() + subTaskB.join();
        }
        return sum;
    }
}

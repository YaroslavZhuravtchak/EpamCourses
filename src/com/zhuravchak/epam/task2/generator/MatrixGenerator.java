package com.zhuravchak.epam.task2.generator;

import java.util.Random;

/**
 * Created by Yaroslav on 26-Jul-17.
 */
public class MatrixGenerator {
    private  int size;

    public MatrixGenerator(int size) {
        this.size = size;
    }

    public float[][] generateMatrix(){
        float[][]  matrix = new float[size][size];
        Random random = new Random();
        for(int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = random.nextFloat() + random.nextInt(100) - 50;
            }
        }
        return matrix;
    }
}

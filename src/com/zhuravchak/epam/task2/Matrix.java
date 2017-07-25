package com.zhuravchak.epam.task2;

import java.util.*;

/**
 * Created by Yaroslav on 22-Jul-17.
 */
public class Matrix {

    private  int size;
    float[][] matrix;

    public Matrix(int size) {
        this.size = size;
        generateMatrix();
    }

    public void generateMatrix(){
        matrix = new float[size][size];
        Random random = new Random();
        for(int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = random.nextFloat() + random.nextInt(100) - 50;
            }
        }
    }

    public void showMatrix() {
        System.out.println();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf("%10.4f", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public void turnMatrix() {

        for (int k=0; k<size/2; k++)
        {
            for (int j=k; j<size-1-k; j++)
            {
                float tmp = matrix[k][j];
                matrix[k][j] = matrix[j][size-1-k];
                matrix[j][size-1-k] = matrix[size-1-k][size-1-j];
                matrix[size-1-k][size-1-j] = matrix[size-1-j][k];
                matrix[size-1-j][k] = tmp;
            }
        }
    }

    public static void main(String[] args) {

        Matrix matrixTurner = new Matrix(6);

        System.out.println("\nOrigin matrix:");
        matrixTurner.showMatrix();

        matrixTurner.turnMatrix();

        System.out.println("\nTurned matrix:");
        matrixTurner.showMatrix();
    }
}

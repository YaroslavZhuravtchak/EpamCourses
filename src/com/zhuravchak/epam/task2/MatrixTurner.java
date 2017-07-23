package com.zhuravchak.epam.task2;

import java.util.*;

/**
 * Created by Yaroslav on 22-Jul-17.
 */
public class MatrixTurner {

    private  int size = 6;

    public float[][] generateMatrix(){
        float[][] matrix = new float[size][size];
        Random random = new Random();
        for(int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = random.nextFloat() + random.nextInt(100) - 50;
            }
        }
        return matrix;
    }

    public void showMatrix(float[][] matrix) {
        System.out.println();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf("%10.4f", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public float[][] turnMatrix(float[][] originMatrix) {
        float[][] turnedMatrix = new float[size][size];
        for (int i = 0, n = 5; i < size; i++, n--) {
            for (int j = 0; j < size; j++) {
                turnedMatrix[i][j] = originMatrix[j][n];
            }
        }
        return turnedMatrix;
    }

    public static void main(String[] args) {
        MatrixTurner matrixTurner = new MatrixTurner();

        float[][] matrix1 = matrixTurner.generateMatrix();

        System.out.println("\nOrigin matrix:");
        matrixTurner.showMatrix(matrix1);

        float[][] matrix2 = matrixTurner.turnMatrix(matrix1);

        System.out.println("\nTurned matrix:");
        matrixTurner.showMatrix(matrix2);
    }
}

package com.zhuravchak.epam.task1.matrix;

import com.zhuravchak.epam.task1.matrix.generator.MatrixGenerator;

/**
 * Created by Yaroslav on 26-Jul-17.
 */
public class App {
    public static void main(String[] args) {

        MatrixGenerator generator = new MatrixGenerator(6);
        Matrix matrix = new Matrix(generator.generateMatrix());

        System.out.println("\nOrigin matrix:");
        matrix.showMatrix();

        matrix.turnMatrix();

        System.out.println("\nTurned matrix:");
        matrix.showMatrix();
    }
}

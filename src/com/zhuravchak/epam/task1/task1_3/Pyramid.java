package com.zhuravchak.epam.task1.task1_3;

import java.io.*;

/**
 * Created by Yaroslav on 22-Jul-17.
 */
public class Pyramid {

    private int widthOfPyramid;
    private int numberOfRows;

    public Pyramid(){
        defineNumberOfRows();
        widthOfPyramid = numberOfRows * 2 - 1;
    }


    public void defineNumberOfRows(){

        System.out.println("Please enter the number of rows in your pyramid(digit only):");

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            numberOfRows = Integer.valueOf(br.readLine());
            if (numberOfRows < 0) {
                throw new NumberFormatException();
            }
            if (numberOfRows > 9) {
                throw new NumberFormatException();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void buildPyramid(){
        System.out.println("\nYour pyramid:\n");
        for (int row = 1; row <= numberOfRows; row++) {
            buildRow(row);
        }
    }

    public void buildRow(int numberOfRow){

        char[] rowOfNumbers = new char[widthOfPyramid];
        int centerOfRow = widthOfPyramid / 2;
        rowOfNumbers[centerOfRow] = (char)(numberOfRow + 48);

        for (int i = 1; i <= centerOfRow; i++) {
            if (--numberOfRow > 0) {
                rowOfNumbers[centerOfRow + i] = (char)(numberOfRow + 48);
                rowOfNumbers[centerOfRow - i] = (char)(numberOfRow + 48);
            }
            else {
                rowOfNumbers[centerOfRow + i] = rowOfNumbers[centerOfRow - i] = ' ';
            }
        }

        System.out.println(rowOfNumbers);
    }

    public static void main(String[] args) {
        try {
            Pyramid pyramid = new Pyramid();
            pyramid.buildPyramid();
        } catch (NumberFormatException e) {
            System.out.println("It's not a digit");
        }
    }
}

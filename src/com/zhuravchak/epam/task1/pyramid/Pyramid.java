package com.zhuravchak.epam.task1.pyramid;

import java.io.*;

/**
 * Created by Yaroslav on 22-Jul-17.
 */
public class Pyramid {

    private int widthOfPyramid;
    private int numberOfRows;

    public void inputSizeOfPyramid(){

        System.out.println("Please enter the number of rows in your pyramid(digit only):");

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            numberOfRows = Integer.valueOf(br.readLine());
            if (numberOfRows < 0) {
                throw new NumberFormatException("Not a positive number");
            }
            if (numberOfRows > 9) {
                throw new NumberFormatException("Not a digit");
            }
            widthOfPyramid = numberOfRows * 2 - 1;
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
}

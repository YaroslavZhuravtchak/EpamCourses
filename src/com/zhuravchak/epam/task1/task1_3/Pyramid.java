/**
 * Created by Yaroslav on 22-Jul-17.
 */
package com.zhuravchak.epam.task1.task1_3;
import java.io.*;

public class Pyramid {
    private int widthOfPyramid;

    public Pyramid(){
        makePyramid();
    }

    public void makePyramid(){
       int numberOfRows = defineNumberOfRows();
       if(numberOfRows==-1) {
           return;
       }
       buildRows(numberOfRows);
    }

    public int defineNumberOfRows(){
        System.out.println("Please enter the number of rows  in your pyramid(digit only):");
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int numberOfRows=Integer.valueOf(br.readLine());
            if(numberOfRows<0) {
                throw new Exception("It's not a positive number");
            }
            if(numberOfRows>9) {
                throw new Exception("It's not a digit");
            }
            return numberOfRows;
        }catch (IOException e){
            e.printStackTrace();
        }catch (NumberFormatException e){
            System.out.println("It's not a integer number");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return -1;
    }

    public void buildRows(int numberOfRows){
        widthOfPyramid=numberOfRows*2-1;
        System.out.println("\nYour pyramid:\n");
        for(int row =1;row<=numberOfRows;row++){
            buildRow(row);
        }
    }

    public void buildRow(int numberOfRow){
        char[] rowOfNumbers = new char[widthOfPyramid];
        int centerOfRow=widthOfPyramid/2;
        rowOfNumbers[centerOfRow]=(char)(numberOfRow+48);
        for(int i=1,j;i<=centerOfRow;i++){
            if(--numberOfRow>0){
                rowOfNumbers[centerOfRow+i]=rowOfNumbers[centerOfRow-i]=(char)(numberOfRow+48);
            }
            else {
                rowOfNumbers[centerOfRow + i] = rowOfNumbers[centerOfRow - i] = ' ';
            }
        }
        System.out.println(rowOfNumbers);
    }

    public static void main(String[] args) {
        new Pyramid();
    }
}

package com.zhuravchak.epam.task5.task5_1_1;

/**
 * Created by Yaroslav on 15-Aug-17.
 */
public class Main {
    public static void main(String[] args) {
        new Thread(){
         public void run(){
            for(int i = 10; i>=0; i--){
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Bomb");
         }
        }.start();
    }
}

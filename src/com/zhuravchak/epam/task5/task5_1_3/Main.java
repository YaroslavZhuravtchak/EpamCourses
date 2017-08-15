package com.zhuravchak.epam.task5.task5_1_3;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
/**
 * Created by Yaroslav on 15-Aug-17.
 */
public class Main {
    public static void main(String[] args) {

        HashMap<Integer, String> data = new HashMap<>(1000, 0.7f);
        ConcurrentHashMap<Integer, String> concData = new ConcurrentHashMap<>(1000,0.7f);

        int numberOfThreads = 10;
        int numberOfElements = 1000;

        Writer[] writers = new Writer[numberOfThreads];
        Reader[] readers = new Reader[numberOfThreads];

        CWriter[] cwriters = new CWriter[numberOfThreads];
        CReader[] creaders = new CReader[numberOfThreads];

        /* HashMap */
        long start = System.nanoTime();

        for(int i = 0; i < numberOfThreads; i++){
            writers[i] = new Writer(data, "T"+i, (numberOfElements/numberOfThreads)*i, (numberOfElements/numberOfThreads)*(i+1));
        }

        for(int i = 0; i < numberOfThreads; i++){
            readers[i] = new Reader(data, (numberOfElements/numberOfThreads)*i, (numberOfElements/numberOfThreads)*(i+1));
        }

        for(Writer writer : writers){
            try {
                writer.t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for(Reader reader : readers){
            try {
                reader.t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print("Запис і читання HashMap:           ");
        System.out.println(System.nanoTime()-start);

        /* ConcurrentHashMap */
        start = System.nanoTime();

        for(int i = 0; i < numberOfThreads; i++){
            cwriters[i] = new CWriter(concData, "T"+i, (numberOfElements/numberOfThreads)*i, (numberOfElements/numberOfThreads)*(i+1));
        }

        for(int i = 0; i < numberOfThreads; i++){
            creaders[i] = new CReader(concData, (numberOfElements/numberOfThreads)*i, (numberOfElements/numberOfThreads)*(i+1));
        }

        for(CWriter cwriter : cwriters){
            try {
                cwriter.t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for(CReader creader : creaders){
            try {
                creader.t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print("Запис і читання ConcurrentHashMap: ");
        System.out.println(System.nanoTime()-start);
    }
}

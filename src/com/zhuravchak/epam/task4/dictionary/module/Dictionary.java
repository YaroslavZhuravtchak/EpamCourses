package com.zhuravchak.epam.task4.dictionary.module;

import java.io.*;
import java.util.*;

/**
 * Created by Yaroslav on 05-Aug-17.
 */
public class Dictionary {
    public HashMap<String,String> worldsInDictionary = new HashMap<>();

    public void initDictionary(){
        try(BufferedReader br = new BufferedReader(new FileReader("Dictionary.txt"))){
            while (true) {
                try {
                   String str = br.readLine();
                    if(str==null)break;
                   String[] strArr = str.split("\t",2);
                    if (strArr.length > 1) {
                        worldsInDictionary.put(strArr[0].trim(), strArr[1].trim());
                    } else if(strArr.length > 1){
                        worldsInDictionary.put(strArr[0].trim(), "");
                    }
                } catch (EOFException e) {
                    break;
                }
           }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void addWorld(String en, String ua){
        worldsInDictionary.put(en, ua);

        try(BufferedWriter br = new BufferedWriter(new FileWriter("Dictionary.txt", true))){
            br.append(en + "\t" + ua);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public String translateText(String text){

        StringBuilder translatedText = new StringBuilder();
        String[] worldsToTranslate = text.split(" ");

        for(int i = 0; i<worldsToTranslate.length;i++) {
            if(worldsInDictionary.containsKey(worldsToTranslate[i].toLowerCase())) {
               worldsToTranslate[i] = worldsInDictionary.get(worldsToTranslate[i].toLowerCase());
            }
            translatedText.append(worldsToTranslate[i]);
            translatedText.append(" ");
        }
        return translatedText.toString();
    }
}

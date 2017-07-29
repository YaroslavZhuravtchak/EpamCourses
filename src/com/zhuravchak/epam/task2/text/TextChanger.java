package com.zhuravchak.epam.task2.text;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Yaroslav on 26-Jul-17.
 */
public class TextChanger {

    Scanner scanner = new Scanner(System.in);

    public StringBuilder inputText(){

        System.out.println("Введіть текст:");
        StringBuilder text = new StringBuilder();

        String str;
        do {
            str = scanner.nextLine();
            text.append(str);
            text.append("\n");
        } while (!str.equals(""));

        return text;
    }

    public String inputSubstring(){
        System.out.println("Введіть підстроку:");
            return scanner.nextLine();

    }

    public int inputPosition(){
        System.out.println("Введіть позицію:");
            return scanner.nextInt();
    }

    public String changeText(StringBuilder text, String substring, int position){

        Pattern p = Pattern.compile("[.!?]+\\s");
        Matcher m = p.matcher(text);


        int start = 0;
        int end ;

        while(m.find()){

            end = m.start();

            if (position <= end-start) {
                text.insert(position + start, substring);
                start = m.end() + substring.length();
            } else {
                start = m.end();
            }
        }

       if(position < text.length()- start-2) {
            text.insert(position + start, substring);
       }

        return text.toString();
    }

}

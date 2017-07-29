package com.zhuravchak.epam.task3.text;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Yaroslav on 28-Jul-17.
 */
public class TextFinder {



    public StringBuilder inputText(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("    Введіть текст(для виходу нажміть Enter двічі):");
        StringBuilder text = new StringBuilder();

        String str;
        do {
            str = scanner.nextLine();
            text.append(str);
            text.append("\n");
        } while (!str.equals(""));

        return text;
    }

    public String findText(StringBuilder text, String expression){

        Pattern p = Pattern.compile(expression);
        Matcher m = p.matcher(text);
        StringBuilder matches = new StringBuilder();
        while(m.find()){
            matches.append(m.group());
            matches.append("\n");
        }

        return matches.toString();
    }
}

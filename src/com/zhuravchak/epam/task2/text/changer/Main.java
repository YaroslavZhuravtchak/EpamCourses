package com.zhuravchak.epam.task2.text.changer;

/**
 * Created by Yaroslav on 26-Jul-17.
 */
public class Main {

    public static void main(String[] args) {

        TextChanger textChanger = new TextChanger();

        String changedText = textChanger.changeText(textChanger.inputText(),
                                                    textChanger.inputSubstring(),
                                                    textChanger.inputPosition() );
        System.out.println("\nЗмінений текст:\n");
        System.out.println(changedText);
    }
}

package com.zhuravchak.epam.task2.text.finder;

/**
 * Created by Yaroslav on 28-Jul-17.
 */
public class Main {
    public static void main(String[] args) {

        TextFinder tf = new TextFinder();
        String expression = "([/]{2,2})[a-z]*[F-K]+";

        String matches = tf.findText(tf.inputText(), expression);

        if (!matches.equals("")) {
            System.out.println("    Знайдено:");
            System.out.println(matches);
        } else {
            System.out.println("Співпадінь не знайдено");
        }
    }
}

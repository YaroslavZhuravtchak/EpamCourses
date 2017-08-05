package com.zhuravchak.epam.task4.dictionary.menu;

import java.util.*;

/**
 * Created by Yaroslav on 05-Aug-17.
 */
public class Menu {

    com.zhuravchak.epam.task4.dictionary.module.Dictionary dictionary;
    Scanner scanner = new Scanner(System.in);
    public Menu(com.zhuravchak.epam.task4.dictionary.module.Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public static void showMenu(){
        System.out.println("________________________________________________________\n"+
                "Введіть:\n" +
                " T  для перекладу тексту\n" +
                " A  для додавання слова в словник\n" +
                " E  для виходу\n"+
                "________________________________________________________\n");
    }

    public  String getSrtingFromConsole(){

        String str = scanner.next();
        return str;
    }
    public String inputText(){

        System.out.println("Введіть текст:");

        String str = scanner.nextLine();
        scanner.reset();

        return str;
    }

    public void runMenu(){



        while (true) {
            showMenu();
            String ch = getSrtingFromConsole();

            if (ch.equalsIgnoreCase("T")) {
                Scanner in = new Scanner(System.in);
                System.out.println("Введіть англійський текст: ");
                String text = in.nextLine();
                String translatedText = dictionary.translateText(text);
                System.out.println("Переклад: ");
                System.out.println(translatedText);

            } else if (ch.equalsIgnoreCase("A")) {

                System.out.println("Введіть англійське слово: ");
                String en = "\n" + getSrtingFromConsole();
                System.out.println("Введіть переклад: ");
                String ua = getSrtingFromConsole();
                    dictionary.addWorld(en, ua);
                System.out.println("Слово додано");

            } else if (ch.equalsIgnoreCase("E")) {
                break;
            }
        }
    }
}

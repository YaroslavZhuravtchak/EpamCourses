package com.zhuravchak.epam.task5.task5_2;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.RecursiveAction;

/**
 * Created by Yaroslav on 16-Aug-17.
 */
public class Replacer extends RecursiveAction {
    private File file;

    public Replacer(File file) {
        this.file = file;
    }

    @Override
    protected void compute() {

            File[] files = file.listFiles();

            for(int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    invokeAll(new Replacer(files[i]));
                } else {
                    String name = files[i].getName();
                    String[] str = name.split("[.]");

                    if(str.length==2&&str[1].equals("java")){

                        try (Scanner sc = new Scanner(files[i]).useDelimiter("[ \\s,)'\"@<>{}/\\]\\[=+\\-*|&(?!:;.\\n]")) {
                            String search;
                            String replace;
                            Path path = files[i].toPath();
                            Charset charset = StandardCharsets.UTF_8;

                            while(sc.hasNext()) {
                                search = sc.next();
                               if(search.length()>3) {
                                   replace = search.toUpperCase();
                                   System.out.println(name + ":  " + search + " -> " + replace);
                                   Files.write(path,
                                           new String(Files.readAllBytes(path), charset).replace(search, replace)
                                                   .getBytes(charset));
                                }
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                     }
            }
        }
    }
}

package com.zhuravchak.epam.task4.reflect.reflectstring;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Yaroslav on 04-Aug-17.
 */
public class StringReflection {

  public void reflectString(String str, char[] arr){

      try {
          Class stringClass = str.getClass();
          Field field = stringClass.getDeclaredField("value");
          field.setAccessible(true);
          field.set(str, arr);

      } catch (NoSuchFieldException|IllegalAccessException e) {
          e.printStackTrace();
      }
  }
}

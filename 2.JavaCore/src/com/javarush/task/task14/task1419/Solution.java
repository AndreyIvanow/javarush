package com.javarush.task.task14.task1419;

import java.util.*;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
            exceptions.add(new NullPointerException());
            exceptions.add(new IndexOutOfBoundsException());
            exceptions.add(new ArithmeticException());
            exceptions.add(new EmptyStackException());
            exceptions.add(new IllegalFormatWidthException(4));
            exceptions.add(new ArrayIndexOutOfBoundsException());
            exceptions.add(new ConcurrentModificationException());
            exceptions.add(new SecurityException());
            exceptions.add(new UnknownFormatFlagsException("d"));
        }



    }
}

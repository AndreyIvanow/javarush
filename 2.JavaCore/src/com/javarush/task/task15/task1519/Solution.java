package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String key = null;


        while (true){
            key = reader.readLine();
            try {
                if ("exit".equals(key)){
                    break;
                } else if (key.contains(".")){
                    print(Double.parseDouble(key));
                } else if (Integer.parseInt(key) >= 128 || Integer.parseInt(key) <= 0){
                    print(Integer.parseInt(key));
                }
                else if (Short.parseShort(key) > 0 && Short.parseShort(key) < 128){
                    print(Short.parseShort(key));
                }
            } catch (Exception e){
                print(key);
            }

        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}

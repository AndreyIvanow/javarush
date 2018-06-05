package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String request = reader.readLine();
        String[] half = request.split("\\?");

        String[] params =  half[1].split("&");
        String value = null;
        for (String param : params){
            if ("obj".equals(param.split("=")[0])){
                value = param.split("=")[1];
            }
            System.out.println(param.split("=")[0]);
        }

        if (value != null){
                try {
                   alert(Double.parseDouble(value));
                } catch (NumberFormatException e){
                    alert(value);
                }
        }


    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}

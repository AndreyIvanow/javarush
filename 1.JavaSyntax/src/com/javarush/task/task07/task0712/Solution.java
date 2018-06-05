package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<>();
        TreeSet<String> set = new TreeSet<>((a, b) -> a.length() - b.length());
        for (int i = 0; i < 10; i++){
            String value = reader.readLine();
            list.add(value);
            set.add(value);
        }

        int longestSize = set.last().length();
        int shortestSize = set.first().length();

        for (String string : list){
            if (string.length() == longestSize || string.length() == shortestSize){
                System.out.println(string);
                break;
            }
        }
        //напишите тут ваш код
    }
}

package com.javarush.task.task10.task1015;

import java.util.ArrayList;
import java.util.StringJoiner;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        ArrayList<String>[] s = new ArrayList[2];
        s[0] = new ArrayList<>();
        s[0].add("01");
        s[0].add("02");
        s[1] = new ArrayList<>();
        s[1].add("11");
        return s;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}
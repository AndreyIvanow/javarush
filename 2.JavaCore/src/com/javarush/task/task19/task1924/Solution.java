package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        Set<String> numbers = map.keySet().stream().map(n -> n.toString()).collect(Collectors.toSet());

        try(BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            while (fileReader.ready()){
                String line = fileReader.readLine();
                StringBuilder lineToShow = new StringBuilder();
                String words[] = line.split(" ");
                for (String word : words){
                    if (numbers.contains(word)){
                        lineToShow.append(map.get(Integer.parseInt(word)) + " ");
                        continue;
                    }
                    lineToShow.append(word + " ");
                }
                System.out.println(lineToShow);
            }
        }

    }
}

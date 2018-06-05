package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        TreeMap<String, Double> map = new TreeMap<>();
        while (reader.ready()){
            String line = reader.readLine();
            String[] values = line.split(" ");
            map.merge(values[0], Double.parseDouble(values[1]), Double::sum);
        }
        reader.close();

        map.forEach((k, v) -> System.out.println(k + " " + v));
    }
}

package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException {

        String fileName = args[0];
        TreeMap<String, Double> map = new TreeMap<>();
        TreeSet<Double> set = new TreeSet<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName));) {
            while (reader.ready()){
                String line = reader.readLine();
                String[] values = line.split(" ");
                String key = values[0];
                map.merge(key, Double.parseDouble(values[1]), Double::sum);
                set.add(map.get(key));
            }
        }
        Double max = set.last();
        map.forEach((k, v) -> {
            if (max.equals(v)){
                System.out.println(k);
            }
        });
    }
}

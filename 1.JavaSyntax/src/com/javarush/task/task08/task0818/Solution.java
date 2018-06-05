package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Иванов", 1050);
        map.put("Тереньтев", 100);
        map.put("Ефимов", 600);
        map.put("Левчук", 1200);
        map.put("Власова", 200);
        map.put("Кожевников", 200);
        map.put("Фоминов", 700);
        map.put("Мелешко", 900);
        map.put("Урузбахтин", 550);
        map.put("Янин", 70);
        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> current = iterator.next();
            if (current.getValue() < 500) iterator.remove();
        }

    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = createMap();
        removeItemFromMap(map);
    }
}
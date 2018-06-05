package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.TreeMap;

public class Solution {

    public static void main(String[] args) throws IOException {
        String tagName = args[0];
        String tagOpen = "<" + tagName;
        String tagClosed = "</" + tagName;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //String fileName = reader.readLine();
        String fileName = "D:\\IdeaProjects\\JavaRushHomeWork\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1918\\tags.html";
        reader.close();

        StringBuilder builder = new StringBuilder();
        try(BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            while (fileReader.ready()){
                builder.append(fileReader.readLine());
            }
        }

        int tagOpenIndex = 0;
        int tagCloseIndex = 0;
        int i = 0;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        TreeMap<Integer, String> result = new TreeMap<>();
        while (true){
            tagOpenIndex = builder.indexOf(tagOpen, i);
            tagCloseIndex = builder.indexOf(tagClosed, i);
            if (tagOpenIndex == -1 && tagCloseIndex == -1) break;
            if(tagOpenIndex != -1 && tagOpenIndex < tagCloseIndex){
                deque.add(tagOpenIndex);
                i = tagOpenIndex + 1;
            } else {
                i = tagCloseIndex + tagClosed.length();
                int j = deque.pollLast();
                result.put(j, builder.substring(j, i + 1));
            }

        }
        result.forEach((k, v) -> System.out.println(v));
    }

    /*// возвращает индекс n-ого вхождения подстроки
    private static int nthOccurence(String source, String pattern, int n) {
        int globalPos = 0;
        for (int i = 0; i < n; i++){
            int pos = source.indexOf(pattern);
            if (pos > -1) {
                source = source.substring(pos+1);
                globalPos += pos + 1;
            } else {
                return -1;
            }
        }
        return globalPos - 1;
    }*/


}

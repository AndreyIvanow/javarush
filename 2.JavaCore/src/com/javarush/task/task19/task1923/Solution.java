package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName1 = args[0];
        String fileName2 = args[1];
        Pattern pattern = Pattern.compile("\\d");

        try(BufferedReader fileReader = new BufferedReader(new FileReader(fileName1));
            FileWriter fileWriter = new FileWriter(fileName2)) {
            while (fileReader.ready()){
                String line = fileReader.readLine();
                String[] words = line.split(" ");
                for (String word : words){
                    Matcher matcher = pattern.matcher(word);
                    if (matcher.find()){
                        fileWriter.write(word + " ");
                    }
                }
            }
        }

    }
}

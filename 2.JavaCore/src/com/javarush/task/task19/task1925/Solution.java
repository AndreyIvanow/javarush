package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName1 = args[0];
        String fileName2 = args[1];

        StringBuilder builder = new StringBuilder();

        try(BufferedReader fileReader = new BufferedReader(new FileReader(fileName1));
            FileWriter fileWriter = new FileWriter(fileName2)) {
            while (fileReader.ready()){
                String line = fileReader.readLine();
                String[] words = line.split(" ");
                for (int i = 0; i < words.length; i++){
                  if (words[i].length() > 6){
                      builder.append(words[i] + ",");
                  }
                }
            }
            builder.deleteCharAt(builder.lastIndexOf(","));
            fileWriter.write(builder.toString());
        }
    }
}

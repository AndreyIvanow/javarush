package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>(10);
        String wrongElem = null;
        for (int i = 0; i < 10; i++){
            String value = reader.readLine();
            if (i != 0 && wrongElem == null && value.length() < list.get(i - 1).length()){
                wrongElem = value;
            }
            list.add(value);
        }

        if (wrongElem != null){
            System.out.println(list.indexOf(wrongElem));
        }
    }
}


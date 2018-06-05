package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.*;

/* 
Cамая длинная последовательность
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            list.add(Integer.parseInt(reader.readLine()));
        }
        int currentSequenceSize = 1;
        int maxSize = 1;
        for (int i = 0; i < list.size() - 1; i++){
            if (list.get(i).equals(list.get(i + 1))){
                currentSequenceSize++;
                if (maxSize < currentSequenceSize) maxSize = currentSequenceSize;
            } else {
                currentSequenceSize = 1;
            }
        }

        System.out.println(maxSize);

    }
}
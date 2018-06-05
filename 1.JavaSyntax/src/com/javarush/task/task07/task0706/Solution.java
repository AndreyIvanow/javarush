package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.InputStreamReader;/*
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] houses = new int[15];
        int evenSum = 0;
        int oddSum = 0;
        for (int i = 0; i < 15; i++){
            int value = Integer.valueOf(reader.readLine());
            houses[i] = value;
            if (isEven(i)){
                evenSum += value;
            } else {
                oddSum += value;
            }
        }
        reader.close();
        System.out.println(String.format("В домах с %s номерами проживает больше жителей.", evenSum > oddSum ? "четными" : "нечетными"));
    }

    public static boolean isEven(int num){
        return num % 2 == 0;
    }
}

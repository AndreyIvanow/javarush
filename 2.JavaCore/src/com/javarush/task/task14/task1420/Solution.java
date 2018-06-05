package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            int a = Integer.parseInt(reader.readLine());
            if (a <= 0){
                throw new Exception();
            }
            int b = Integer.parseInt(reader.readLine());
            if (b <= 0){
                throw new Exception();
            }
            getGreatestCommonDivisor(a, b);






    }

    public static void getGreatestCommonDivisor(int a, int b){
        if (b > a){
            int buf = a;
            a = b;
            b = buf;
        }
        if (a % b == 0){
            System.out.println(b);
        } else {
            getGreatestCommonDivisor(b, a % b);
        }
    }
}

package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Закрепляем Singleton pattern
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static Planet thePlanet;

   static {
       try {
           readKeyFromConsoleAndInitPlanet();
       }
       catch (IOException e){
           System.out.println(e);
       }

   }

    public static void readKeyFromConsoleAndInitPlanet() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String key = reader.readLine();
        if (Planet.EARTH.equals(key)){
            thePlanet = Earth.getEarth();
        } else if (Planet.MOON.equals(key)){
            thePlanet = Moon.getMoon();
        } else if (Planet.SUN.equals(key)){
            thePlanet = Sun.getSun();
        } else thePlanet = null;
        reader.close();
    }
}

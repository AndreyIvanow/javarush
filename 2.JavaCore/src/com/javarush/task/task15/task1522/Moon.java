package com.javarush.task.task15.task1522;

/**
 * Created by Андрей on 31.05.2017.
 */
public class Moon implements Planet{

    private static Moon moon;

    private Moon (){

    }

    public static Moon getMoon(){
        if (moon == null){
            moon = new Moon();
        }
        return moon;
    }
}

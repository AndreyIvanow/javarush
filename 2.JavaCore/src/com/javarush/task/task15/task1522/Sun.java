package com.javarush.task.task15.task1522;

/**
 * Created by Андрей on 31.05.2017.
 */
public class Sun implements Planet {

    private static Sun sun;

    private Sun (){

    }

    public static Sun getSun(){
        if (sun == null){
            sun = new Sun();
        }
        return sun;
    }
}

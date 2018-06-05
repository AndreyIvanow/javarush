package com.javarush.task.task15.task1522;

/**
 * Created by Андрей on 31.05.2017.
 */

public class Earth implements Planet{

    private static Earth earth;

    private Earth (){

    }

    public static Earth getEarth(){
        if (earth == null){
            earth = new Earth();
        }
        return earth;
    }
}

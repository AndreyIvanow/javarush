package com.javarush.task.task19.task1921;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<>();
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("d-M-yyyy");

    public static void main(String[] args) throws IOException, ParseException {
        String fileName = args[0];
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.ready()){
                String[] rowData = reader.readLine().split(" ");
                StringBuilder nameBuilder = new StringBuilder();
                StringBuilder dateBuilder = new StringBuilder();
                for(String el : rowData){
                    if (!el.matches("[\\d]+")) {
                        nameBuilder.append(el).append(" ");
                    } else {
                        dateBuilder.append(el).append("-");
                    }
                }
                PEOPLE.add(new Person(nameBuilder.toString().trim(), dateFormat.parse(dateBuilder.toString())));
            }
        }
    }
}

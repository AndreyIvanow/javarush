package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String fileName = reader.readLine();
            FileInputStream fileInputStream = new FileInputStream(fileName);
            load(fileInputStream);
            fileInputStream.close();
        }
    }

    public void save(OutputStream outputStream) throws Exception {
        Properties props = new Properties();
        for (Map.Entry<String, String> entry : properties.entrySet()){
            props.setProperty(entry.getKey(), entry.getValue());
        }
        props.store(outputStream, null);
    }

    public void load(InputStream inputStream) throws Exception {
        Properties props = new Properties();
        props.load(inputStream);
        for (Map.Entry<Object, Object> entry : props.entrySet()){
            properties.put((String)entry.getKey(), (String)entry.getValue());
        }
    }

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        solution.fillInPropertiesMap();
    }
}

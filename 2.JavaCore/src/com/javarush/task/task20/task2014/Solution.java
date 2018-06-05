package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) {
        Solution savedObject = null;
        Solution loadedObject = null;
        try {
            File your_file_name = File.createTempFile("JavaRush", ".txt", new File("D:\\IdeaProjects\\JavaRushHomeWork\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2014"));
            FileOutputStream fileOutputStream = new FileOutputStream(your_file_name);
            FileInputStream fileInputStream = new FileInputStream(your_file_name);
            ObjectOutput objectOutput = new ObjectOutputStream(fileOutputStream);
            ObjectInput objectInput = new ObjectInputStream(fileInputStream);
            savedObject = new Solution(23);
            objectOutput.writeObject(savedObject);
            loadedObject = (Solution) objectInput.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(loadedObject.string.equals(savedObject.string));
        System.out.println(new Solution(4));

    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}

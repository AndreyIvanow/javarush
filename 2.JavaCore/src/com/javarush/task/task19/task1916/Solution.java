package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        //String fileName1 = "D:\\IdeaProjects\\JavaRushHomeWork\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1916\\file1.txt";
        String fileName2 = reader.readLine();
        //String fileName2 = "D:\\IdeaProjects\\JavaRushHomeWork\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1916\\file2.txt";
        reader.close();
        List<String> originalRows = new ArrayList<>();
        List<String> editedRows = new ArrayList<>();
        try(BufferedReader fileReader1 = new BufferedReader(new FileReader(fileName1));
            BufferedReader fileReader2 = new BufferedReader(new FileReader(fileName2))) {
            while (fileReader1.ready()){
                originalRows.add(fileReader1.readLine());
            }
            while (fileReader2.ready()){
                editedRows.add(fileReader2.readLine());
            }
        }

        //List<String> lines = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (true){
            // Если одинаковые - просто инкрементим счетчики
            if (i <= originalRows.size() - 1 && j <= editedRows.size() - 1 && originalRows.get(i).equals(editedRows.get(j))){
                lines.add(new LineItem(Type.SAME, originalRows.get(i)));
                    i++;
                    j++;
            // Если дошли до конца оригинального файла
            } else if (i == originalRows.size() - 1){
                // если в измененном файле уже не осталось строк значит строку удалили
                if (j > editedRows.size() - 1){
                    lines.add(new LineItem(Type.REMOVED, originalRows.get(i)));
                    i++;
                    // если остались, то текущая строка из измененного файла была добавлена
                } else {
                    lines.add(new LineItem(Type.ADDED, editedRows.get(j)));
                    j++;
                }
            // Если дошли до конца измененного файла
            } else if (j == editedRows.size() - 1){
                if (i > originalRows.size() - 1){
                    lines.add(new LineItem(Type.ADDED, editedRows.get(j)));
                    j++;
                } else {
                    lines.add(new LineItem(Type.REMOVED, originalRows.get(i)));
                    i++;
                }
            } else if (originalRows.get(i + 1).equals(editedRows.get(j))){
                lines.add(new LineItem(Type.REMOVED, originalRows.get(i)));
                if (i < originalRows.size() - 1){
                    i++;
                }
            } else if (editedRows.get(j + 1).equals(originalRows.get(i))){
                lines.add(new LineItem(Type.ADDED, editedRows.get(j)));
                if (j < editedRows.size() - 1){
                    j++;
                }
            }

            if (i > originalRows.size() - 1 && j > editedRows.size() - 1){
                break;
            }

        }
        System.out.println(lines);

    }


    public enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}

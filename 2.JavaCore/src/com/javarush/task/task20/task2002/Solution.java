package com.javarush.task.task20.task2002;

import java.io.*;
import java.security.cert.CollectionCertStoreParameters;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-DD");
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("JavaRush", ".txt", new File("D:\\IdeaProjects\\JavaRushHomeWork\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2002"));
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            User user1 = new User("Andrey", "Ivanov", dateFormat.parse("1993-06-08"), true, User.Country.RUSSIA);
            User user2 = new User(null, null, null, false, User.Country.OTHER);
            JavaRush javaRush1 = new JavaRush();
            javaRush1.users = Arrays.asList(user1, user2);
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush1.save(outputStream);
            JavaRush javaRush2 = new JavaRush();
            User user3 = new User("Alexander", "Druz", dateFormat.parse("1995-06-09"), true, User.Country.OTHER);
            javaRush2.users = Arrays.asList(user3);
            javaRush2.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject1 = new JavaRush();
            loadedObject1.load(inputStream);
            if (javaRush1.equals(loadedObject1)){
                System.out.println("They are equals!");
            }
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public boolean isNullOrEmpty(String s){
            return s == null || s.equals("");
        }

        public void save(OutputStream outputStream) throws Exception {
            Integer usersSize = this.users.size();
            outputStream.write(String.valueOf(usersSize).getBytes());
            outputStream.write(System.lineSeparator().getBytes());
            for (User user : users){
                user.save(outputStream);
            }
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            Integer usersSize = Integer.parseInt(reader.readLine());
            for (int i = 0; i < usersSize; i++){
                String firstName = reader.readLine().trim();
                firstName = isNullOrEmpty(firstName) ? null : firstName;
                String secondName = reader.readLine().trim();
                secondName = isNullOrEmpty(secondName) ? null : secondName;
                String birthDayString = reader.readLine().trim();
                Date birthDay = isNullOrEmpty(birthDayString) ? null : new Date(Long.parseLong(birthDayString));
                Boolean isMale = Boolean.parseBoolean(reader.readLine());
                String countryString = reader.readLine();
                User.Country country = isNullOrEmpty(countryString) ? null : User.Country.valueOf(countryString);
                this.users.add(new User(firstName, secondName, birthDay, isMale, country));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}

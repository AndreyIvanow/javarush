package com.javarush.task.task20.task2013;

import java.io.*;
import java.util.Arrays;
import java.util.List;

/* 
Externalizable Person
*/
public class Solution {
    public static class Person implements Externalizable {
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public Person() {
        }

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(mother);
            out.writeObject(father);
            out.writeObject(firstName);
            out.writeObject(lastName);
            out.writeInt(age);
            out.writeObject(children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            mother = (Person)in.readObject();
            father = (Person)in.readObject();
            firstName = (String)in.readObject();
            lastName = (String)in.readObject();
            if (in.available() > 0) {
                age = in.readInt();
            }
            children = (List)in.readObject();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File your_file_name = File.createTempFile("JavaRush", ".txt", new File("D:\\IdeaProjects\\JavaRushHomeWork\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2013"));
        FileOutputStream fileOutputStream = new FileOutputStream(your_file_name);
        FileInputStream fileInputStream = new FileInputStream(your_file_name);
        ObjectOutput objectOutput = new ObjectOutputStream(fileOutputStream);
        ObjectInput objectInput = new ObjectInputStream(fileInputStream);
        Person person = new Person("Andrey", "Ivanov", 24);
        person.setChildren(Arrays.asList(new Person("Alena", "Ivanova", 2)));
        person.writeExternal(objectOutput);
        Person readPerson = new Person();
        readPerson.readExternal(objectInput);
        System.out.println(person.equals(readPerson));

    }
}

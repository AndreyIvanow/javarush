package com.javarush.task.task12.task1226;

/* 
Fly, Run, Climb для классов Cat, Dog, Tiger, Duck
*/

public class Solution {

     interface Fly {
        void fly();
    }

    interface Run {
         void run();
    }

    interface Climb{
         void climb();
    }

    public class Cat implements Run, Climb {
        @Override
        public void run() {

        }

        @Override
        public void climb() {

        }
    }

    public class Dog implements Run, Climb {
        @Override
        public void run() {

        }

        @Override
        public void climb() {

        }
    }
    public class Tiger extends Cat implements Run, Climb {
        @Override
        public void run() {

        }

        @Override
        public void climb() {

        }
    }

    public class Duck implements Fly, Run {
        @Override
        public void fly() {

        }

        @Override
        public void run() {

        }
    }
}

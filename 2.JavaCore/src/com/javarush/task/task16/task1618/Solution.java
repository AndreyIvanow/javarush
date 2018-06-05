package com.javarush.task.task16.task1618;

/* 
Снова interrupt
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Thread testThread = new TestThread();
        testThread.start();
        Thread.sleep(200);
        testThread.interrupt();
    }


    public static class TestThread extends Thread {



        public void run() {
            while (!currentThread().isInterrupted()){
                System.out.println("I am alive!");
            }
        }
    }
}
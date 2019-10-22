package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        Thread t1 = new Thread1();
        Thread t2 = new Thread2();
        Thread t3 = new Thread3();
        Thread t4 = new Thread4();
        Thread t5 = new Thread5();
        threads.add(t1);
        threads.add(t2);
        threads.add(t3);
        threads.add(t4);
        threads.add(t5);

    }

    public static void main(String[] args) {
    }

    public static class Thread1 extends Thread{
        @Override
        public void run() {
            while (true){ }
        }
    }

    public static class Thread2 extends Thread{
        @Override
        public void run() {
            if (Thread.currentThread().isInterrupted()){
                try {
                    throw new InterruptedException();
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException");
                }
            }
        }
    }

    public static class Thread3 extends Thread{
        @Override
        public void run() {
            while (true){
                try {
                    System.out.println("Ура");
                    Thread.sleep(500);
                } catch (InterruptedException e) { }
            }
        }
    }

    public static class Thread4 extends Thread implements Message{
        boolean isStopped = false;
        @Override
        public void run() {
            while (!isStopped){}
        }

        @Override
        public void showWarning() {
            isStopped = true;
        }
    }

    public static class Thread5 extends Thread{
        @Override
        public void run() {
            try {
                int sum = 0;
                String s;
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                while (true){
                    s = reader.readLine();
                    if (s.equals("N")){
                        break;
                    } else {
                        sum += Integer.parseInt(s);
                    }
                }
                reader.close();
                System.out.println(sum);
            } catch (IOException e) {
            }
        }
    }
}
package com.javarush.task.task14.task1421;

public class Singleton {

    private static Singleton instance;

    public static Singleton getInstance(){
        if (count == 0){
            instance = new Singleton();
            count++;
        }
        return instance;
    }

    private Singleton() {
    }

    private static short count = 0;
}

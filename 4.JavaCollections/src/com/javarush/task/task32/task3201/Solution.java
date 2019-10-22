package com.javarush.task.task32.task3201;

import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) {
        try {
            RandomAccessFile raf = new RandomAccessFile(args[0], "rw");
            int number = Integer.parseInt(args[1]);
            String text = args[2];
            if (raf.length() < number){
                raf.seek(raf.length());
            } else {
                raf.seek(number);
            }
            raf.write(text.getBytes());

        } catch (IOException e){
            System.err.println("Failure");
        }
    }
}

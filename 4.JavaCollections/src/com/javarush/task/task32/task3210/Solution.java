package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) {
        try {
            RandomAccessFile raf = new RandomAccessFile(args[0], "rw");
            int number = Integer.parseInt(args[1]);
            byte[] byteArray = args[2].getBytes();
            byte[] buffer = new byte[byteArray.length];
            raf.seek(number);
            raf.read(buffer, 0, byteArray.length);
            String readText = new String(buffer);
            raf.seek(raf.length());
            if (readText.equals(args[2])){
                raf.write("true".getBytes());
            } else {
                raf.write("false".getBytes());
            }
        } catch (IOException e){
            System.err.println("Failure");
        }
    }
}

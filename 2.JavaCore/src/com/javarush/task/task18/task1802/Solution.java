package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(name);
        int minByte = 1000;
        while (fileInputStream.available() > 0){
            int dataByte = fileInputStream.read();
            if (dataByte < minByte) minByte = dataByte;
        }
        reader.close();
        fileInputStream.close();
        System.out.println(minByte);
    }
}

package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(name);
        int maxByte = 0;
        while (fileInputStream.available() > 0){
            int dataByte = fileInputStream.read();
            if (dataByte > maxByte) maxByte = dataByte;
        }
        reader.close();
        fileInputStream.close();
        System.out.println(maxByte);
    }
}

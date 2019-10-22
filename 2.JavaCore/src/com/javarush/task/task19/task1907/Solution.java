package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        reader.close();
        int count = 0;
        StringBuilder stringBuilder = new StringBuilder();
        FileReader fileReader = new FileReader(name);
        while (fileReader.ready()){
            char c = (char) fileReader.read();
            stringBuilder.append(c);
        }
        fileReader.close();
        String[] strArr = stringBuilder.toString().split("\\W");
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].equals("world")) count++;
        }
        System.out.println(count);
    }
}

package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        BufferedReader fileReader = new BufferedReader(new FileReader(name1));
        String name2 = reader.readLine();
        reader.close();
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(name2, true));
        StringBuilder stringBuilder = new StringBuilder();
        while (fileReader.ready()){
            char c = (char) fileReader.read();
            stringBuilder.append(c);
        }
        fileReader.close();
        String[] strArr = stringBuilder.toString().split(" ");
        System.out.println(strArr[0]);
        for (int i = 0; i < strArr.length; i++) {
            try {
                Integer.parseInt(strArr[i]);
                fileWriter.write((strArr[i] + " "));
            } catch (NumberFormatException e){
            }
        }
        fileWriter.close();
    }
}

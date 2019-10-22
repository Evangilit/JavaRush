package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        FileReader fileReader = new FileReader(name1);
        String name2 = reader.readLine();
        reader.close();
        FileWriter fileWriter = new FileWriter(name2);
        boolean even = false;
        while (fileReader.ready()){
            int data = fileReader.read();
            if (even){
                fileWriter.write(data);
                even = false;
            } else {
                even = true;
            }
        }
        fileReader.close();
        fileWriter.close();

    }
}

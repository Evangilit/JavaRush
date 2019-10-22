package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        BufferedReader fileReader = new BufferedReader(new FileReader(name1));
        String name2 = reader.readLine();
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(name2));
        reader.close();
        while (fileReader.ready()){
            String result = fileReader.readLine().replaceAll("\\p{Punct}", "");
            fileWriter.write(result );
        }
        fileReader.close();
        fileWriter.close();
    }
}

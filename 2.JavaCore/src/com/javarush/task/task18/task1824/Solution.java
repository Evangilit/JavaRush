package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        try {
            while (true){
                s = reader.readLine();
                FileInputStream fis = new FileInputStream(s);
                fis.close();
            }
        } catch (FileNotFoundException e){
            System.out.println(s);
        }
    }
}

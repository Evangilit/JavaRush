package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String file1, file2;
            file1 = reader.readLine();
            file2 = reader.readLine();
            FileInputStream fileInputStream = new FileInputStream(file1);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            if (fileInputStream.available() > 0){
                byte[] buffer = new byte[fileInputStream.available()];
                fileInputStream.read(buffer);
                for (int i = buffer.length-1; i >= 0; i--) {
                    fileOutputStream.write(buffer[i]);
                }
            }
            reader.close();
            fileInputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

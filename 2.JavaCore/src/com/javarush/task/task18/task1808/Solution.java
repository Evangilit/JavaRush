package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String file1, file2, file3;
            file1 = reader.readLine();
            file2 = reader.readLine();
            file3 = reader.readLine();
            FileInputStream fileInputStream = new FileInputStream(file1);
            FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
            FileOutputStream fileOutputStream3 = new FileOutputStream(file3);
            if (fileInputStream.available() > 0){
                if ((fileInputStream.available() % 2) == 0){
                    byte[] buffer1 = new byte[fileInputStream.available()/2];
                    byte[] buffer2 = new byte[fileInputStream.available()/2];
                    copyPast(buffer1, fileInputStream, fileOutputStream2);
                    copyPast(buffer2, fileInputStream, fileOutputStream3);
                } else {
                    byte[] buffer1 = new byte[fileInputStream.available()/2 + 1];
                    byte[] buffer2 = new byte[fileInputStream.available()/2];
                    copyPast(buffer1, fileInputStream, fileOutputStream2);
                    copyPast(buffer2, fileInputStream, fileOutputStream3);
                }
            }
            reader.close();
            fileInputStream.close();
            fileOutputStream2.close();
            fileOutputStream3.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void copyPast (byte[] b, FileInputStream fileInputStream, FileOutputStream fileOutputStream) throws IOException {
        fileInputStream.read(b);
        fileOutputStream.write(b);
    }
}

package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String name1, name2;
            name1 = reader.readLine();
            name2 = reader.readLine();
            BufferedInputStream file1In = new BufferedInputStream(new FileInputStream(name1));
            BufferedInputStream file2In = new BufferedInputStream(new FileInputStream(name2));
            byte [] buffer1 = new byte[file1In.available()];
            file1In.read(buffer1);
            byte [] buffer2 = new byte[file2In.available()];
            file2In.read(buffer2);
            file1In.close();
            file2In.close();
            BufferedOutputStream file1Out = new BufferedOutputStream(new FileOutputStream(name1));
            file1Out.write(buffer2);
            file1Out.write(buffer1);
            file1Out.close();
        } catch (Exception e) {
        }

    }
}

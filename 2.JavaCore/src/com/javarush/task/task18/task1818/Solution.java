package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String name1, name2, name3;
            name1 = reader.readLine();
            name2 = reader.readLine();
            name3 = reader.readLine();
            BufferedInputStream file2 = new BufferedInputStream(new FileInputStream(name2));
            BufferedInputStream file3 = new BufferedInputStream(new FileInputStream(name3));
            FileOutputStream file1 = new FileOutputStream(name1, true);
            byte[] buffer = new byte[file2.available()];
            file2.read(buffer);
            file1.write(buffer);
            buffer = new byte[file3.available()];
            file3.read(buffer);
            file1.write(buffer);
            file1.close();
            file2.close();
            file3.close();
        } catch (IOException e) {
        }

    }
}

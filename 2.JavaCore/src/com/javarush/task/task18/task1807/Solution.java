package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int count = 0;
            FileInputStream fileInputStream = new FileInputStream(reader.readLine());
            while (fileInputStream.available() > 0){
                int data = fileInputStream.read();
                if (data == 44) count++;
            }
            reader.close();
            fileInputStream.close();
            System.out.println(count);
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}

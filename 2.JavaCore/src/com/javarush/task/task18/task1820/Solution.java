package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            ArrayList<Integer> arr = new ArrayList<>();
            String name1, name2;
            name1 = reader.readLine();
            name2 = reader.readLine();
            BufferedReader reader1 = new BufferedReader(new FileReader(name1));
            String str = reader1.readLine();
            reader.close();
            reader1.close();
            String[] strArr = str.split(" ");
            BufferedWriter file2Out = new BufferedWriter(new FileWriter(name2));
            for (int i = 0; i < strArr.length; i++) {
                int b = (int) Math.round(Double.parseDouble(strArr[i]));
                System.out.print(b + " ");
                file2Out.write(b + " ");
            }
            file2Out.close();
        } catch (Exception e) {
        }
    }
}

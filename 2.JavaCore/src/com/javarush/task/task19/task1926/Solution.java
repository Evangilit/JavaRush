package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        reader.close();
        ArrayList<String> strArr = new ArrayList<>();
        BufferedReader bfr = new BufferedReader(new FileReader(name));
        while (bfr.ready()){
            strArr.add(bfr.readLine());
        }
        bfr.close();
        for (int i = 0; i < strArr.size(); i++) {
            for (int j = strArr.get(i).length()-1; j >= 0; j--) {
                System.out.print(strArr.get(i).charAt(j));
            }
            System.out.println();
        }
    }
}
